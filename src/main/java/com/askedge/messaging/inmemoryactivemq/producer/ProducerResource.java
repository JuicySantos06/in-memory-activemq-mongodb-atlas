package com.askedge.messaging.inmemoryactivemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

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
        return "message published successfully to the in-memory activemq queue";
    }

}