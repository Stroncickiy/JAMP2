package com.epam.spring.jms.listener;

import com.epam.spring.jms.Destinations;
import com.epam.spring.model.UserAction;
import com.epam.spring.service.UserActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class UserActionListener {
    static final Logger LOG = LoggerFactory.getLogger(UserActionListener.class);
    @Autowired
    private UserActionService userActionService;

    @JmsListener(destination = Destinations.USER_ACTIONS_DESTINATION_NAME)
    public void receiveUserAction(final Message<UserAction> message) throws JmsException {
        MessageHeaders headers = message.getHeaders();
        LOG.info("UserActionLogger : headers received : {}", headers);

        UserAction action = message.getPayload();
        LOG.info("UserActionLogger : action received : {}", action);

        userActionService.add(action);
    }
}
