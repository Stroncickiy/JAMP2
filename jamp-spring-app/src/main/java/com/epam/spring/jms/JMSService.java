package com.epam.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Topic;
import java.io.Serializable;
import java.util.Map;

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

    public void sendMessageToQueue(final Queue destination, final Serializable object, Map<String, Object> properties) {
        jmsQueueTemplate.setDefaultDestination(destination);
        jmsQueueTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(object);
            injectProperties(objectMessage, properties);
            return objectMessage;
        });
    }

    public void sendMessageToTopic(final Topic destination, final Serializable object, Map<String, Object> properties) {
        jmsTopicTemplate.setDefaultDestination(destination);
        jmsTopicTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(object);
            injectProperties(objectMessage, properties);
            return objectMessage;
        });
    }

    private void injectProperties(ObjectMessage objectMessage, Map<String, Object> properties) throws JMSException {
        if (properties != null) {
            for (String propKey : properties.keySet()) {
                Object propValue = properties.get(propKey);
                objectMessage.setObjectProperty(propKey, propValue);
            }
        }

    }


}
