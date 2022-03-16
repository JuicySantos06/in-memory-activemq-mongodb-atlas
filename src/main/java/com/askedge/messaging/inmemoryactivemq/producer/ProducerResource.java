package com.askedge.messaging.inmemoryactivemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/amq/mdb")
public class ProducerResource {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @PostMapping("/publish")
    public String postBody(@RequestBody String message) {

        jmsTemplate.convertAndSend(queue, message);
        return "Message published successfully to the in-memory ActiveMQ broker";
    }
}