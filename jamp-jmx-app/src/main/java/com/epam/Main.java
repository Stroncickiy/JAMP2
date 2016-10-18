package com.epam;

import com.epam.jms.Broker;
import com.epam.model.BookingInfo;
import com.epam.model.Ticket;
import com.epam.service.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        Broker broker = startServices();

        if (broker != null) {

            Ticket ticket = new Ticket();

            TicketReservationService ticketReservationService = new TicketReservationService(broker);
            BookingInfo bookingInfo = ticketReservationService.prepareBooking(ticket);

            ticketReservationService.book(ticket);

            ticketReservationService.unsubscribeUserFromNews(ticket.getPassengers().get(0));
            ticketReservationService.subscribeUserOnNews(ticket.getPassengers().get(0));

        }

    }

    public static Broker startServices() {
        Broker broker = null;
        try {
            broker = new Broker();
        } catch (RuntimeException e) {
            System.out.format(" Broker did not started due to %S", e.getMessage());
        }

        executorService.execute(new AncillaryService(broker));
        executorService.execute(new LuggageService(broker));
        executorService.execute(new NotificationService(broker));
        executorService.execute(new NewsProvider("General News ", broker));
        executorService.execute(new NewsProvider("Advertisements  ", broker));

        return broker;
    }
}
