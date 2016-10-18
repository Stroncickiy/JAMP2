package com.epam.service;


import com.epam.Application;
import com.epam.jms.Broker;
import com.epam.model.LuggageAllowance;
import com.epam.model.Ticket;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class LuggageService implements Runnable {

    private Broker broker;

    public LuggageService(Broker broker) {

        this.broker = broker;
    }

    @Override
    public void run() {
        System.out.printf(" Luggage Service Started ");
        listenForRequests();
        System.out.printf(" Luggage Service Stopped  ");
    }


    private void listenForRequests() {
        Session session = broker.obtainSession();
        try {
            MessageConsumer consumer = session.createConsumer(broker.getBookingServiceDestination());
            Message message;
            while (!Application.NEED_TO_STOP) {
                if ((message = consumer.receive(2000l)) != null) {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        Object object = objectMessage.getObject();
                        Ticket ticket = (Ticket) object;
                        if (object instanceof Ticket) {
                            Destination replyToDestination = message.getJMSReplyTo();
                            MessageProducer replyToMessageProducer = session.createProducer(replyToDestination);
                            Message replyMessage = session.createObjectMessage(getLuggageInfo(ticket));
                            replyToMessageProducer.send(replyMessage);
                            session.commit();
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


    private LuggageAllowance getLuggageInfo(Ticket ticket) {
        LuggageAllowance luggageAllowance = new LuggageAllowance();
        // TODO luggage allowance logic
        return luggageAllowance;
    }

}
