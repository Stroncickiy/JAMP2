package com.epam.service;


import com.epam.jms.Broker;
import com.epam.model.Ancillaries;
import com.epam.model.Ticket;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class AncillaryService implements Runnable {


    private Broker broker;

    public AncillaryService(Broker broker) {

        this.broker = broker;
    }


    public void listenForRequests() {
        Session session = broker.obtainSession();
        try {
            MessageConsumer consumer = session.createConsumer(broker.getAncillaryServiceDestination());
            Message message;
            while (true) {
                if ((message = consumer.receive(2000l)) != null) {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        Object object = objectMessage.getObject();
                        Ticket ticket = (Ticket) object;
                        if (object instanceof Ticket) {
                            Destination replyToDestination = message.getJMSReplyTo();
                            MessageProducer replyToMessageProducer = session.createProducer(replyToDestination);
                            Message replyMessage = session.createObjectMessage(getAvailableAncillaries(ticket));
                            replyToMessageProducer.send(replyMessage);
                            session.commit();
                        }
                    }
                } else {
                    TimeUnit.SECONDS.sleep(1);
                }

            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private Ancillaries getAvailableAncillaries(Ticket ticket) {


        return null;
    }

    @Override
    public void run() {
        System.out.printf("Ancillary Service Started And Waiting for Requests");
        listenForRequests();
    }
}
