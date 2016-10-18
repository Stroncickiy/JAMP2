package com.epam.service;


import com.epam.jms.Broker;
import com.epam.model.User;

import java.util.ArrayList;
import java.util.List;

public class NewsProvider implements Runnable {
    private String topic;
    private Broker broker;
    private List<User> subscribers = new ArrayList<>();

    public NewsProvider(String topic, Broker broker) {
        this.topic = topic;
        this.broker = broker;
    }

    private void registerUser(User userToRegister) {
        subscribers.add(userToRegister);
        System.out.format("News provider %s has registered user %s ", topic, userToRegister.getEmail());
    }


    private void unregisterUser(User userToUnregister) {
        subscribers.remove(userToUnregister);
        System.out.format("News provider %s has unregistered user %s ", topic, userToUnregister.getEmail());
    }


    public void sendNews(String news) {
        for (User subscriber : subscribers) {
            System.out.println(" news: " + news + " was sent to " + subscriber.getEmail());
        }
    }

    @Override
    public void run() {
        
    }
}
