package com.epam.websockets.client;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import com.epam.websockets.decoder.MessageDecoder;
import com.epam.websockets.model.Message;

public class Client {
	private static MessageDecoder decoder = new MessageDecoder();
	public static final String SERVER = "ws://localhost:8025/ws/chat";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	public static void main(String[] args) throws Exception {
		ClientManager client = ClientManager.createClient();
		String message;
		// connect to server
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tiny Chat!");
		System.out.println("What's your name?");
		String user = scanner.nextLine();
		Session session = client.connectToServer(ChatClientEndpoint.class, new URI(SERVER));
		System.out.println("You are logged in as: " + user);

		// repeatedly read a message and send it to the server (until quit)
		do {
			message = scanner.nextLine();
			String jsonOfMessage = formatMessage(message, user);
			session.getBasicRemote().sendText(jsonOfMessage);
			printSelfMessage(jsonOfMessage);
		} while (!message.equalsIgnoreCase("quit"));
	}

	private static void printSelfMessage(String jsonOfMessage) throws DecodeException {
		Message messageObject = decoder.decode(jsonOfMessage);
		  System.out.println(String.format("[%s:%s] %s",
			         simpleDateFormat.format(messageObject.getReceived()), "ME", messageObject.getContent()));
	}

	private static String formatMessage(String message, String user) {
		return Json
				.createObjectBuilder()
				.add("message", message)
				.add("sender", user)
				.add("received", "")
				.build()
				.toString();
	}

}