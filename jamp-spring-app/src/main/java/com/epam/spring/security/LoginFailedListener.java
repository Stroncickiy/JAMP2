package com.epam.spring.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.epam.spring.enums.ActionType;
import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.UserAction;

@Component
public class LoginFailedListener implements ApplicationListener<BadCredentialsEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(LoginFailedListener.class);
    @Autowired
    private JMSService JMSService;

    @Override
    public void onApplicationEvent(BadCredentialsEvent event) {
        UserAction userAction = UserAction.builder()
                .email(event.getUsername())
                .success(false)
                .timestamp(new Date())
                .ip(event.getIp())
                .actionType(ActionType.LOGIN)
                .session(null)
                .build();
        LOG.info("LoginFailedListener : sending login action {} to jms destination  ", userAction);
        Map<String, Object> properties = new HashMap<>();
        properties.put("action", "login");
        properties.put("success", false);
        JMSService.sendMessageToTopic(new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC), userAction, properties);
        LOG.debug("Failed login using USERNAME [" + event.getUsername() + "]");
    }
}