package com.epam.service;


import com.epam.Application;
import com.epam.jms.Broker;
import com.epam.model.News;
import com.epam.model.SubscribeRQ;
import com.epam.model.UnsubscribeRQ;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmailService implements Runnable {
    private String topic;
    private Broker broker;
    private List<String> subscribers = new ArrayList<>();

    public EmailService(String topic, Broker broker) {
        this.topic = topic;
        this.broker = broker;
    }

    private void registerUser(String userToRegister) {
        subscribers.add(userToRegister);
        System.out.format("News provider %s has registered user %s ", topic, userToRegister);
    }


    private void unregisterUser(String userToUnregister) {
        subscribers.remove(userToUnregister);
        System.out.format("News provider %s has unregistered user %s ", topic, userToUnregister);
    }


    private void sendNews(News news) {
        if (news.getAllowedProviders().contains(topic)) {
            for (String subscriber : subscribers) {
                System.out.println(" news: " + news.getNews() + " was sent to " + subscriber);
            }
        }
    }


    private void listenForRequests() {
        Session session = broker.obtainSession();
        try {
            MessageConsumer consumer = session.createConsumer(broker.getAncillaryServiceDestination());
            Message message;
            while (!Application.NEED_TO_STOP) {
                if ((message = consumer.receive(2000l)) != null) {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        Object object = objectMessage.getObject();
                        if (object instanceof SubscribeRQ) {
                            SubscribeRQ subscribeRQ = (SubscribeRQ) object;
                            registerUser(subscribeRQ.getTargetUser().getEmail());
                        } else if (object instanceof UnsubscribeRQ) {
                            UnsubscribeRQ unsubscribeRQ = (UnsubscribeRQ) object;
                            unregisterUser(unsubscribeRQ.getTargetUser().getEmail());
                        } else if (object instanceof News) {
                            News news = (News) object;
                            sendNews(news);
                        }
                    }
                } else {
                    TimeUnit.MILLISECONDS.sleep(100);
                }

            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        System.out.printf("Email Service %s Service Started And Waiting for Requests", topic);
        listenForRequests();
        System.out.printf("Email Service %s stopped ");
    }

}
