package com.epam;

import com.epam.jms.Broker;
import com.epam.model.BookingInfo;
import com.epam.model.Ticket;
import com.epam.service.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static boolean NEED_TO_STOP;
    private static ExecutorService executorService = Executors.newFixedThreadPool(7);

    public static void main(String[] args) {

        Broker broker = startServices();

        if (broker != null) {

            Ticket ticket = new Ticket();

            TicketReservationService ticketReservationService = new TicketReservationService(broker);
            BookingInfo bookingInfo = ticketReservationService.prepareBooking(ticket);

            ticketReservationService.book(ticket);

            ticketReservationService.unsubscribeUserFromNews(ticket.getPassengers().get(0));
            ticketReservationService.subscribeUserOnNews(ticket.getPassengers().get(0));

            NEED_TO_STOP = true;
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
        executorService.execute(new BookingService(broker));

        executorService.execute(new EmailService("ADS", broker));
        executorService.execute(new EmailService("NEWS", broker));

        return broker;
    }
}
