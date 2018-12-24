package com.gailo22.springcloudstreamkafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class SpringCloudStreamKafkaApplication {

    private static final String MEETUP_RSVPS_ENDPOINT = "ws://stream.meetup.com/2/rsvps";

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializeConnection(RsvpsWebSocketHandler rsvpsWebSocketHandler) {
        return args -> {
            StandardWebSocketClient standardWebSocketClient = new StandardWebSocketClient();

            standardWebSocketClient.doHandshake(rsvpsWebSocketHandler, MEETUP_RSVPS_ENDPOINT);
        };
    }

}

