package com.epam.websockets.client;

import java.net.URI;
import java.util.Scanner;

import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import com.epam.websockets.decoder.MessageDecoder;
import com.epam.websockets.model.Message;
import com.epam.websockets.model.MessageType;

public class Client {
	private static MessageDecoder decoder = new MessageDecoder();
	public static final String SERVER = "ws://localhost:8025/ws/chat";

	public static void main(String[] args) throws Exception {
		ClientManager client = ClientManager.createClient();
		String message;
		// connect to server
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tiny Chat! to get help you can write 'help' to server  ");
		Session session = client.connectToServer(ChatClientEndpoint.class, new URI(SERVER));
		// repeatedly read a message and send it to the server (until quit)
		do {
			message = scanner.nextLine();
			if (message.trim().toLowerCase().startsWith(MessageType.AUTH.name().toLowerCase() + "|")) {
				String username = message.substring(message.indexOf("|")+1, message.length());
				session.getBasicRemote().sendText(formatMessage(username, MessageType.AUTH));
			} else if (message.trim().toLowerCase().startsWith(MessageType.GET_USERS.name().toLowerCase())) {
				session.getBasicRemote().sendText(formatMessage("", MessageType.GET_USERS));
			} else if (message.trim().toLowerCase().startsWith(MessageType.HELP.name().toLowerCase())) {
				session.getBasicRemote().sendText(formatMessage("", MessageType.HELP));
			} else if (!message.trim().equalsIgnoreCase("quit")){
				String jsonOfMessage = formatMessage(message, MessageType.OUT);
				session.getBasicRemote().sendText(jsonOfMessage);
				printSelfMessage(jsonOfMessage);
			}
		} while (!message.trim().equalsIgnoreCase("quit"));
		scanner.close();
	}

	private static void printSelfMessage(String jsonOfMessage) throws DecodeException {
		Message messageObject = decoder.decode(jsonOfMessage);
		System.out.println(messageObject.getType().messageToString(messageObject));
	}

	private static String formatMessage(String message, MessageType messageType) {
		return Json.createObjectBuilder()
				.add("message", message)
				.add("timestamp", "")
				.add("type", messageType.name())
				.build().toString();
	}

}