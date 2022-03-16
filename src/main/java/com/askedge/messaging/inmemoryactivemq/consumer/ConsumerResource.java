package com.askedge.messaging.inmemoryactivemq.consumer;

import com.squareup.okhttp.*;
import org.bson.json.JsonObject;
import org.bson.json.JsonParseException;
import org.json.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumerResource {


    @JmsListener(destination = "mdb.inmemory.queue")
    public void listener(String message) throws IOException, InterruptedException {
        System.out.println("Message consumed successfully from the in-memory ActiveMQ broker: " + message);

        String json = message;
        JSONObject mongoJsonObject = new JSONObject(json);

        String inputData = "{\"dataSource\":\"AtlasMQ\",\"database\":\"sample_customers\",\"collection\":\"users\",\"document\":" + mongoJsonObject + "}";

        System.out.println("Request body:" + inputData);

        String atlasEndpoint = "https://data.mongodb-api.com/app/data-tnssi/endpoint/data/beta/action/insertOne";

        var request = HttpRequest.newBuilder()
                .uri(URI.create(atlasEndpoint))
                .header("Content-Type", "application/json")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", "ePqlEr500FhemdTrSedghKpTBFfIsSSHowzX82DYFWrJ5W1zutDgsuPQFJ72GXzX")
                .POST(HttpRequest.BodyPublishers.ofString(inputData))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());




    }
}
