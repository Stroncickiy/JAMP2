package com.epam.spring.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class AdminNotificationService {
    private static Logger LOG = LoggerFactory.getLogger(AdminNotificationService.class);
    @Autowired
    private JavaMailSender sender;
    @Value("${admin.mail}")
    private String adminMail;

    @Autowired
    public void notifyThatUserLoginFailed3Times(String username, SimpleMailMessage mailMessage) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setText("user with username " + username + " attempted to login with bad credentials 3 times within 10 minutes");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
        LOG.info("sending message to admin with warning that user {} failed authentication more than 2 times ", username);
    }

    @Autowired
    public void notifyThatUserLoginFailed10TimesFromOneIp(String ip, SimpleMailMessage mailMessage) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setText("user with ip " + ip + " attempted to login with bad credentials 10 times within 10 minutes");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        LOG.info("sending message to admin with warning that ip {} failed authentication more than 9 times ", ip);
        sender.send(message);
    }
}
