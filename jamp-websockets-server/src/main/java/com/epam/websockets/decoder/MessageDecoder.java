package com.epam.websockets.decoder;

import java.io.StringReader;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.epam.websockets.model.Message;

public class MessageDecoder implements Decoder.Text<Message> {

	@Override
	public Message decode(final String textMessage) throws DecodeException {
		Message message = new Message();
		JsonObject jsonObject = Json.createReader(new StringReader(textMessage)).readObject();
		message.setContent(jsonObject.getString("message"));
		message.setSender(jsonObject.getString("sender"));
		message.setReceived(new Date());
		return message;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean willDecode(String arg0) {
		return true;
	}

}