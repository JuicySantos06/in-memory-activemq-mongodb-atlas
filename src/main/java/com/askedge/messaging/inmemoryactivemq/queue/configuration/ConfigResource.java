package com.askedge.messaging.inmemoryactivemq.queue.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class ConfigResource {

    @Bean
    public Queue queue() {

        return new ActiveMQQueue("mdb.inmemory.queue");
    }
}
