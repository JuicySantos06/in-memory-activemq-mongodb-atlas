package com.askedge.messaging.inmemoryactivemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerResource {

    @JmsListener(destination = "mdb.inmemory.queue")
    public void listener(String message) {

        System.out.println("message consumed successfully from the in-memory activemq queue: " + message);
    }
}
