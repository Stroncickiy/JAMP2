package com.epam.spring.security;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.epam.spring.enums.ActionType;
import com.epam.spring.jms.Destinations;
import com.epam.spring.jms.JMSService;
import com.epam.spring.model.UserAction;

@Component
public class SessionExpiredListener implements ApplicationListener<SessionDestroyedEvent> {
	static final Logger LOG = LoggerFactory.getLogger(SessionExpiredListener.class);
	@Autowired
	private JMSService JMSService;

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		UserDetails userDetails = (UserDetails) event.getSecurityContexts().get(0).getAuthentication().getPrincipal();
		UserAction userAction = UserAction.builder().email(userDetails.getUsername()).success(true)
				.actionType(ActionType.LOGOUT)
				.session(
						((WebAuthenticationDetails) event.getSecurityContexts().get(0).getAuthentication().getDetails())
								.getSessionId())
				.build();
		LOG.info("Session Destroyed Listener : sending logout  action {} to jms destination  ", userAction);
		JMSService.sendMessageToTopic(new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC), userAction);
	}

}