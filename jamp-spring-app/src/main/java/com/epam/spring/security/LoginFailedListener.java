package com.epam.spring.security;

import com.epam.spring.enums.ActionType;
import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.UserAction;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginFailedListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(LoginFailedListener.class);
    @Autowired
    private JMSService JMSService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {

        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        UserAction userAction = UserAction.builder()
                .email(userDetails.getUsername())
                .success(false)
                .timestamp(new Date())
                .actionType(ActionType.LOGIN)
                .session(((WebAuthenticationDetails) event.getAuthentication().getDetails())
                        .getSessionId())
                .build();
        LOG.info("LoginFailedListener : sending login action {} to jms destination  ", userAction);

        Map<String, Object> properties = new HashMap<>();
        properties.put("action", "login");
        properties.put("success", false);

        JMSService.sendMessageToTopic(new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC), userAction, properties);

        Object userName = event.getAuthentication().getPrincipal();
        Object credentials = event.getAuthentication().getCredentials();

        LOG.debug("Failed login using USERNAME [" + userName + "]");
        LOG.debug("Failed login using PASSWORD [" + credentials + "]");
    }
}