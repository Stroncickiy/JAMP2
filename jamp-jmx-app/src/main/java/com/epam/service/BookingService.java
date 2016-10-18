package com.epam.service;


import com.epam.Application;
import com.epam.jms.Broker;
import com.epam.model.Ticket;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class BookingService implements Runnable {


    private Broker broker;

    public BookingService(Broker broker) {

        this.broker = broker;
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
                            Message replyMessage = session.createObjectMessage(bookTicket(ticket));
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

    @Override
    public void run() {
        System.out.printf("Booking Service Started");
        listenForRequests();
        System.out.printf("Booking Service Stopped");
    }


    private Ticket bookTicket(Ticket booking) {
        booking.setBooked(true);
        return booking;
    }
}
