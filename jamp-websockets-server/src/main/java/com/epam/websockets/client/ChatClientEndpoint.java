package com.epam.websockets.client;

import java.text.SimpleDateFormat;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;

import com.epam.websockets.decoder.MessageDecoder;
import com.epam.websockets.encoder.MessageEncoder;
import com.epam.websockets.model.Message;

@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatClientEndpoint {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(String.format("[%s:%s] %s",
         simpleDateFormat.format(message.getReceived()), message.getSender(), message.getContent()));
    }

}