package com.epam.websockets.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;

import com.epam.websockets.decoder.MessageDecoder;
import com.epam.websockets.encoder.MessageEncoder;
import com.epam.websockets.model.Message;

@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatClientEndpoint {

	@OnMessage
	public void onMessage(Message message) {
		System.out.println(message.getType().messageToString(message));
	}

}