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
                sendSubscriptionRequestByJMX(passenger);
            }
        }

    }

    private Ticket senRequestToBookingServiceViaJMS(Ticket ticket) {
        return ticket;
    }

    public void subscribeUserOnNews(User user) {
        sendSubscriptionRequestByJMX(user);
    }


    public void unsubscribeUserFromNews(User user) {
        sendUnsubscriptionRequestByJMX(user);
    }

    private void sendSubscriptionRequestByJMX(User user) {
    }

    private void sendUnsubscriptionRequestByJMX(User user) {
    }

    private LuggageAllowance callLugageServiceViaJMS(Ticket ticket) {
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


        return null;
    }
}
