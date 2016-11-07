package com.epam.spring.jms.listener;


import com.epam.spring.jms.Destinations;
import com.epam.spring.model.InteractionEntry;
import com.epam.spring.service.InteractionEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class RequestsListener {
    static final Logger LOG = LoggerFactory.getLogger(RequestsListener.class);
    @Autowired
    private InteractionEntryService interactionEntryService;

    @JmsListener(destination = Destinations.REQUESTS_TRACKING_DESTINATION, containerFactory = "queueListenerFactory")
    public void saveInteractionToDb(final Message<InteractionEntry> message) throws JmsException {
        MessageHeaders headers = message.getHeaders();
        LOG.info("RequestsListener : headers received : {}", headers);

        InteractionEntry interactionEntry = message.getPayload();
        LOG.info("RequestsListener : interaction saved to db: {}", interactionEntry);

        interactionEntryService.add(interactionEntry);
    }

}
