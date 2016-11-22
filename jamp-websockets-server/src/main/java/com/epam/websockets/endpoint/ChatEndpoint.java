package com.epam.websockets.endpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.epam.websockets.decoder.MessageDecoder;
import com.epam.websockets.encoder.MessageEncoder;
import com.epam.websockets.model.Message;

@ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatEndpoint {

	static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session session) {
		System.out.println(String.format("%s joined the chat room.", session.getId()));
		peers.add(session);
	}

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException, EncodeException {
		// broadcast the message
		for (Session peer : peers) {
			if (!session.getId().equals(peer.getId())) { // do not resend the
															// message to its
															// sender
				peer.getBasicRemote().sendObject(message);
			}
		}
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {
		System.out.println(String.format("%s left the chat room.", session.getId()));
		peers.remove(session);
		// notify peers about leaving the chat room
		for (Session peer : peers) {
			Message message = new Message();
			message.setSender("Server");
			message.setContent(
					String.format("%s left the chat room", (String) session.getUserProperties().get("user")));
			message.setReceived(new Date());
			peer.getBasicRemote().sendObject(message);
		}
	}

}