package com.epam.service;


import com.epam.model.*;

import java.util.List;

public class TicketReservationService {


    public BookingInfo prepareBooking(Ticket ticket) {
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setAvailableAncillaries(callAncillaryServiceViaJMS(ticket));
        bookingInfo.setLuggageAllowance(callLugageServiceViaJMS(ticket));
        return bookingInfo;
    }


    public void book(Ticket ticket) {
        Ticket bookedTicket = senRequestToBookingServiceViaJMS(ticket);
        System.out.println(" Ticket " + ticket + " is booked");
        List<User> passengers = ticket.getPassengers();
        for (User passenger : passengers) {
            sendSubscriptionRequestByJMX(passenger);
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
        return null;
    }
}
