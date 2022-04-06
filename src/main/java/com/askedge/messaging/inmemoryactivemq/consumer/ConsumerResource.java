package com.askedge.messaging.inmemoryactivemq.consumer;

import org.json.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

@Component
public class ConsumerResource {

    @JmsListener(destination = "mdb.inmemory.queue")
    public void listener(String message) throws IOException, InterruptedException {
        System.out.println("Message consumed successfully from the in-memory ActiveMQ broker: " + message);

        Properties props = new Properties();
        props.load(ConsumerResource.class.getClassLoader().getResourceAsStream("application.properties"));
        String atlasApiKey = props.getProperty("mongodb.atlas.api.key");
        String atlasCluster = props.getProperty("mongodb.atlas.cluster");
        String atlasDatabase = props.getProperty("mongodb.atlas.database");
        String atlasCollection = props.getProperty("mongodb.atlas.collection");

        String json = message;
        JSONObject mongoJsonObject = new JSONObject(json);

        String inputData = "{\"dataSource\":\""+atlasCluster+"\",\"database\":\""+atlasDatabase+"\",\"collection\":\""+atlasCollection+"\",\"document\":" + mongoJsonObject + "}";

        System.out.println(inputData);
        String atlasEndpoint = "https://data.mongodb-api.com/app/data-tnssi/endpoint/data/beta/action/insertOne";

        var request = HttpRequest.newBuilder()
                .uri(URI.create(atlasEndpoint))
                .header("Content-Type", "application/json")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", atlasApiKey)
                .POST(HttpRequest.BodyPublishers.ofString(inputData))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());




    }
}
