package com.epam.jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Broker {
    private ConnectionFactory connectionFactory;
    private Destination ancillaryServiceDestination;
    private Destination ancillaryServiceResponseDestination;
    private Destination luggageServiceDestination;
    private Destination luggageServiceResponseDestination;
    private Destination notificationServiceDestination;
    private Destination bookingServiceDestination;
    private Destination bookingServiceResponseDestination;

    public Broker() {
        connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:62626");

        try {
            Session session = connectionFactory.createConnection().createSession(true, Session.SESSION_TRANSACTED);

            bookingServiceDestination = session.createQueue("BOOKINGS_SERVICE_OUT_Q");
            bookingServiceResponseDestination = session.createQueue("BOOKING_SERVICE_IN_Q");

            ancillaryServiceDestination = session.createQueue("ANCILLARY_SERVICE_OUT_Q");
            ancillaryServiceResponseDestination = session.createQueue("ANCILLARY_SERVICE_IN_Q");

            luggageServiceDestination = session.createQueue("LUGGAGE_SERVICE_OUT_Q");
            luggageServiceResponseDestination = session.createQueue("LUGGAGE_SERVICE_IN_Q");

            notificationServiceDestination = session.createTopic("NOTIFICATION_SERVICES_TOPIC");
            session.commit();
        } catch (JMSException e) {
            throw new RuntimeException("Unable to start broker");
        }

    }

    public Session obtainSession() {
        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

        } catch (JMSException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            try {
                session = connection.createSession(true, Session.SESSION_TRANSACTED);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        return session;
    }


    public Destination getAncillaryServiceDestination() {
        return ancillaryServiceDestination;
    }

    public void setAncillaryServiceDestination(Destination ancillaryServiceDestination) {
        this.ancillaryServiceDestination = ancillaryServiceDestination;
    }

    public Destination getAncillaryServiceResponseDestination() {
        return ancillaryServiceResponseDestination;
    }

    public void setAncillaryServiceResponseDestination(Destination ancillaryServiceResponseDestination) {
        this.ancillaryServiceResponseDestination = ancillaryServiceResponseDestination;
    }

    public Destination getLuggageServiceDestination() {
        return luggageServiceDestination;
    }

    public void setLuggageServiceDestination(Destination luggageServiceDestination) {
        this.luggageServiceDestination = luggageServiceDestination;
    }

    public Destination getLuggageServiceResponseDestination() {
        return luggageServiceResponseDestination;
    }

    public void setLuggageServiceResponseDestination(Destination luggageServiceResponseDestination) {
        this.luggageServiceResponseDestination = luggageServiceResponseDestination;
    }

    public Destination getNotificationServiceDestination() {
        return notificationServiceDestination;
    }

    public void setNotificationServiceDestination(Destination notificationServiceDestination) {
        this.notificationServiceDestination = notificationServiceDestination;
    }

    public Destination getBookingServiceDestination() {
        return bookingServiceDestination;
    }

    public void setBookingServiceDestination(Destination bookingServiceDestination) {
        this.bookingServiceDestination = bookingServiceDestination;
    }

    public Destination getBookingServiceResponseDestination() {
        return bookingServiceResponseDestination;
    }

    public void setBookingServiceResponseDestination(Destination bookingServiceResponseDestination) {
        this.bookingServiceResponseDestination = bookingServiceResponseDestination;
    }
}
