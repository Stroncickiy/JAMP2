package com.epam.spring.jms;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSService {

    @Autowired
    private JmsTemplate jmsQueueTemplate;

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    @PostConstruct
    public void init() {
        jmsTopicTemplate.setPubSubDomain(true);
    }

    public void sendMessageToQueue(final Queue destination, final Serializable object) {
        jmsQueueTemplate.setDefaultDestination(destination);
        jmsQueueTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(object);
            return objectMessage;
        });
    }

    public void sendMessageToTopic(final Topic destination, final Serializable object) {
        jmsTopicTemplate.setDefaultDestination(destination);
        jmsTopicTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(object);
            return objectMessage;
        });
    }
}
