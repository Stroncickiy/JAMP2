package com.epam.spring.security;


import com.epam.spring.enums.ActionType;
import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.UserAction;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutHandler extends SimpleUrlLogoutSuccessHandler {
    @Autowired
    private JMSService jmsService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAction userAction = UserAction.builder()
                .email(userDetails.getUsername())
                .success(true)
                .actionType(ActionType.LOGOUT)
                .session(((WebAuthenticationDetails) authentication.getDetails())
                        .getSessionId())
                .build();
        jmsService.sendMessage(new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC), userAction);
        super.onLogoutSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}
