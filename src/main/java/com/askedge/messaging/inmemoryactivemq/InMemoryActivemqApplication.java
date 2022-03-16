package com.askedge.messaging.inmemoryactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.io.IOException;


@SpringBootApplication
public class InMemoryActivemqApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(InMemoryActivemqApplication.class, args);
	}


}
