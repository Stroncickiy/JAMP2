package com.epam.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;
import java.io.Serializable;

@Service
public class JMSService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String destination, final Serializable object) {
        jmsTemplate.setDefaultDestinationName(destination);
        jmsTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(object);
            return objectMessage;
        });
    }
}
