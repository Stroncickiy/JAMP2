package com.epam.websockets.endpoint;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import com.epam.websockets.model.MessageType;

@ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatEndpoint {

	private static final String SERVER = "SERVER";
	static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	static Map<String, String> users = new HashMap<>();

	@OnOpen
	public void onOpen(Session session) {
		System.out.println(String.format("%s joined the chat room.", session.getId()));
		peers.add(session);
	}

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException, EncodeException {
		try {
			switch (message.getType()) {
			case AUTH:
				if(users.containsValue(message.getContent())){
					session.getBasicRemote().sendObject(produceMessage(MessageType.ERR," can not be  authenticated as "+ message.getContent()+ " nickname is occupied.."));
				}else{					
					users.put(session.getId(), message.getContent());
					session.getBasicRemote().sendObject(produceMessage(MessageType.INF," authenticated as "+ message.getContent()));
				}
				break;
			case OUT:
				message.setType(MessageType.IN);
				message.setSender(users.getOrDefault(session.getId(), session.getId()));
				for (Session peer : peers) {
					if (!session.getId().equals(peer.getId())) {
						peer.getBasicRemote().sendObject(message);
					}
				}
				break;
			case GET_USERS:
				session.getBasicRemote()
						.sendObject(produceMessage(MessageType.INF,Arrays.toString(users.values().toArray())));
				break;
				
			case HELP:{
				session.getBasicRemote()
				.sendObject(produceMessage(MessageType.INF, "To authenticate print auth|username , type get_users to get users online and  to write message just type message, to exit type quit "));
				break;
			}
			default:
				break;

			}

		} catch (Exception e) {
			session.getBasicRemote().sendObject(produceMessage(MessageType.ERR, e.getMessage()));
		}

	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {
		System.out.println(String.format("%s left the chat room.", session.getId()));
		peers.remove(session);
		String username = users.get(session.getId());
		users.remove(session.getId());
		// notify peers about leaving the chat room
		for (Session peer : peers) {
			peer.getBasicRemote()
					.sendObject(produceMessage(MessageType.INF, String.format("%s left the chat room", username)));
		}
	}

	private Message produceMessage(MessageType messageType, String content) {
		Message message = new Message();
		message.setType(messageType);
		message.setContent(content);
		message.setSender(SERVER);
		message.setTimestamp(new Date());
		return message;
	}

}