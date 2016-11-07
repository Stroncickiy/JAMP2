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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
                .timestamp(new Date())
                .actionType(ActionType.LOGOUT)
                .session(((WebAuthenticationDetails) authentication.getDetails())
                        .getSessionId())
                .build();
        Map<String, Object> properties = new HashMap<>();
        properties.put("action", "logout");
        properties.put("success", true);
        jmsService.sendMessageToTopic(new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC), userAction, properties);
        super.onLogoutSuccess(httpServletRequest, httpServletResponse, authentication);
    }
}
