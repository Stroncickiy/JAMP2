package com.epam.websockets.encoder;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.epam.websockets.model.Message;

public class MessageEncoder implements Encoder.Text<Message> {

	@Override
	public String encode(final Message message) throws EncodeException {
		return Json
				.createObjectBuilder()
				.add("message", message.getContent())
				.add("sender", message.getSender())
				.add("received", "")
				.build()
				.toString();
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {

	}

}