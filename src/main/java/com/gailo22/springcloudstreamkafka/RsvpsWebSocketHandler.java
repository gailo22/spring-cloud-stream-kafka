package com.gailo22.springcloudstreamkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class RsvpsWebSocketHandler extends AbstractWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(RsvpsWebSocketHandler.class);

    private RsvpsKafkaProducer rsvpsKafkaProducer;

    public RsvpsWebSocketHandler(RsvpsKafkaProducer rsvpsKafkaProducer) {
        this.rsvpsKafkaProducer = rsvpsKafkaProducer;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.debug("New RSVP: {}", message.getPayload());

        rsvpsKafkaProducer.sendRsvpMessage(message);
    }
}
