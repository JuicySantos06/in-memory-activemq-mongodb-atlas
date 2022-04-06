package com.askedge.messaging.inmemoryactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;


@SpringBootApplication
public class InMemoryActivemqApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(InMemoryActivemqApplication.class, args);
	}


}
