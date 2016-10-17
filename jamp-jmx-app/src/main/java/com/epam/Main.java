package com.epam;

import com.epam.model.BookingInfo;
import com.epam.model.Ticket;
import com.epam.service.TicketReservationService;

public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        TicketReservationService ticketReservationService = new TicketReservationService();

        BookingInfo bookingInfo = ticketReservationService.prepareBooking(ticket);

        ticketReservationService.book(ticket);

        ticketReservationService.unsubscribeUserFromNews(ticket.getPassengers().get(0));
        ticketReservationService.subscribeUserOnNews(ticket.getPassengers().get(0));


    }
}
