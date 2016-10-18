package com.epam.service;


import com.epam.jms.Broker;
import com.epam.model.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.util.List;

public class TicketReservationService {


    private Broker broker;


    public TicketReservationService(Broker broker) {
        this.broker = broker;


    }

    public BookingInfo prepareBooking(Ticket ticket) {
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setAvailableAncillaries(callAncillaryServiceViaJMS(ticket));
        bookingInfo.setLuggageAllowance(callLugageServiceViaJMS(ticket));
        return bookingInfo;
    }


    public void book(Ticket ticket) {
        Ticket bookedTicket = senRequestToBookingServiceViaJMS(ticket);
        if (bookedTicket.isBooked()) {
            System.out.format(" Ticket %s is booked", ticket);
            List<User> passengers = ticket.getPassengers();
            for (User passenger : passengers) {
                sendSubscriptionRequestViaJMX(passenger, "NEWS", "ADS");
            }
        }

    }

    private Ticket senRequestToBookingServiceViaJMS(Ticket ticket) {
        Session session = broker.obtainSession();
        try {
            MessageProducer producer = session.createProducer(broker.getBookingServiceDestination());
            Message message = session.createObjectMessage(ticket);
            message.setJMSReplyTo(broker.getBookingServiceResponseDestination());
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }


        // TODO receive response
        return null;
    }

    public void subscribeUserOnNews(User user) {
        sendSubscriptionRequestViaJMX(user);
    }


    public void unsubscribeUserFromNews(User user) {
        sendUnsubscriptionRequestViaJMX(user);
    }

    private void sendSubscriptionRequestViaJMX(User user, String... topics) {
        Session session = broker.obtainSession();
        try {
            MessageProducer producer = session.createProducer(broker.getNotificationServiceDestination());
            Message message = session.createObjectMessage(new SubscribeRQ(user, topics));
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void sendUnsubscriptionRequestViaJMX(User user, String... topics) {
        Session session = broker.obtainSession();
        try {
            MessageProducer producer = session.createProducer(broker.getNotificationServiceDestination());
            Message message = session.createObjectMessage(new UnsubscribeRQ(user, topics));
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private LuggageAllowance callLugageServiceViaJMS(Ticket ticket) {

        Session session = broker.obtainSession();
        try {
            MessageProducer producer = session.createProducer(broker.getLuggageServiceDestination());
            Message message = session.createObjectMessage(ticket);
            message.setJMSReplyTo(broker.getLuggageServiceResponseDestination());
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }


        // TODO receive response
        return null;
    }

    private Ancillaries callAncillaryServiceViaJMS(Ticket ticket) {
        Session session = broker.obtainSession();
        try {
            MessageProducer producer = session.createProducer(broker.getAncillaryServiceDestination());
            Message message = session.createObjectMessage(ticket);
            message.setJMSReplyTo(broker.getAncillaryServiceResponseDestination());
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        // TODO receive response
        return null;
    }
}
