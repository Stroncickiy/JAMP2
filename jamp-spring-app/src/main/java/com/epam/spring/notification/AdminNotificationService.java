package com.epam.spring.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AdminNotificationService {
	private static Logger LOG = LoggerFactory.getLogger(AdminNotificationService.class);
	@Autowired
	private JavaMailSender sender;
	@Autowired
	@Qualifier("messageToAdmin")
	private SimpleMailMessage mailMessage;

	@Async
	public void notifyThatUserLoginFailed3Times(String username) {
		LOG.debug("sending message to admin with warning that user {} failed authentication more than 2 times ",
				username);
		mailMessage.setText("user with username " + username
				+ " attempted to login with bad credentials 3 times within 10 minutes");

		sender.send(mailMessage);
	}

	@Async
	public void notifyThatUserLoginFailed10TimesFromOneIp(String ip) {
		LOG.debug("sending message to admin with warning that ip {} failed authentication more than 9 times ", ip);
		mailMessage
				.setText("user with ip " + ip + " attempted to login with bad credentials 10 times within 10 minutes");
		sender.send(mailMessage);
	}
}
