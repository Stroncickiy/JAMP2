package com.epam.service;


import com.epam.jms.Broker;
import com.epam.model.User;

public class NotificationService  implements  Runnable{


    private Broker broker;

    public NotificationService(Broker broker) {

        this.broker = broker;
    }

    private void subscribeUser(User user) {
        // TODO send subscription message to topic
    }


    private void unsubscribeUser(User user) {
        // TODO send un subscription message to topic
    }


    @Override
    public void run() {

    }
}
