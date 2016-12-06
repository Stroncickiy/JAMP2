package com.epam.spring.jms.listener;


import com.epam.spring.jms.Destinations;
import com.epam.spring.model.UserAction;
import com.epam.spring.notification.AdminNotificationService;
import net.jodah.expiringmap.ExpiringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

@Component
public class FailedLoginTracker {
    static final Logger LOG = LoggerFactory.getLogger(FailedLoginTracker.class);
    private Map<String, LongAdder> failedLoginsForLast10MinByUsername = ExpiringMap.builder()
            .expiration(10, TimeUnit.MINUTES)
            .build();

    private Map<String, LongAdder> failedLoginsForLast10MinByIp = ExpiringMap.builder()
            .expiration(10, TimeUnit.MINUTES)
            .build();

    @Autowired
    private AdminNotificationService notificationService;

    @JmsListener(destination = Destinations.USER_ACTIONS_TOPIC, containerFactory = "topicListenerFactory", selector = " (action = 'login') AND (success = FALSE) ")
    public void receiveUserAction(final Message<UserAction> message) throws JmsException {
        UserAction loginFailedAction = message.getPayload();
        LOG.info("FailedLoginTracker : action received : {}", loginFailedAction);


        failedLoginsForLast10MinByUsername.computeIfAbsent(loginFailedAction.getEmail(), s -> {
            LongAdder longAdder = new LongAdder();
            longAdder.add(1L);
            return longAdder;
        });

        failedLoginsForLast10MinByUsername.computeIfPresent(loginFailedAction.getEmail(), (s, longAdder) -> {
            if (longAdder.intValue() == 3) {
                // means that it is third attempt for current user
                notificationService.notifyThatUserLoginFailed3Times(loginFailedAction.getEmail());
            }
            longAdder.add(1L);
            return longAdder;
        });

        failedLoginsForLast10MinByIp.computeIfAbsent(loginFailedAction.getIp(), s -> {
            LongAdder longAdder = new LongAdder();
            longAdder.add(1L);
            return longAdder;
        });

        failedLoginsForLast10MinByIp.computeIfPresent(loginFailedAction.getIp(), (s, longAdder) -> {
            if (longAdder.intValue() == 10) {
                // means that it is tenth attempt for current ip
                notificationService.notifyThatUserLoginFailed10TimesFromOneIp(loginFailedAction.getIp());
            }
            longAdder.add(1L);
            return longAdder;
        });


    }
}
