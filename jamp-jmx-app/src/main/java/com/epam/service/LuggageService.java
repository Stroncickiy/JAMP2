package com.epam.service;


import com.epam.jms.Broker;
import com.epam.model.LuggageAllowance;
import com.epam.model.Ticket;

public class LuggageService implements Runnable {

    private Broker broker;

    public LuggageService(Broker broker) {

        this.broker = broker;
    }

    @Override
    public void run() {

    }

    private LuggageAllowance getLuggageInfo(Ticket ticket) {
        return null;
    }
}
