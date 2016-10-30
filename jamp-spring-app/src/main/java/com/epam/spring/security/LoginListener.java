package com.epam.spring.security;

import com.epam.spring.enums.ActionType;
import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.UserAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
    static final Logger LOG = LoggerFactory.getLogger(LoginListener.class);
    @Autowired
    private JMSService JMSService;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        UserAction userAction = UserAction.builder()
                .email(userDetails.getUsername())
                .success(true)
                .actionType(ActionType.LOGIN)
                .session(((WebAuthenticationDetails) event.getAuthentication().getDetails())
                        .getSessionId())
                .build();
        LOG.info("LoginListener : sending login action {} to jms destination  ", userAction);
        JMSService.sendMessage(Destinations.USER_ACTIONS_DESTINATION_NAME, userAction);
    }
}