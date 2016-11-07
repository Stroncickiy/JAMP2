package com.epam.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {
	@Value("${notification.host}")
	private String host;
	@Value("${notification.port}")
	private String port;
	@Value("${notification.password}")
	private String password;
	@Value("${notification.username}")
	private String username;
	@Value("${admin.mail}")
	private String adminMail;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);
		javaMailSender.setHost(host);
		javaMailSender.setPort(Integer.valueOf(port));
		javaMailSender.getJavaMailProperties().put("mail.smtp.host", host);
		javaMailSender.getJavaMailProperties().put("mail.smtp.port", port);
		//javaMailSender.getJavaMailProperties().put("mail.debug", "true");
		javaMailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
		javaMailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");
		javaMailSender.getJavaMailProperties().setProperty("mail.smtp.socketFactory.port", port);
		javaMailSender.getJavaMailProperties().setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		javaMailSender.getJavaMailProperties().setProperty("mail.smtp.socketFactory.fallback", "false");
		javaMailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
		javaMailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");
		return javaMailSender;
	}

	@Bean("messageToAdmin")
	@Scope(scopeName = "prototype")
	public SimpleMailMessage templateMessage() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(username);
		simpleMailMessage.setSubject("Warning to administrator");
		simpleMailMessage.setTo(adminMail);
		return simpleMailMessage;
	}
}
