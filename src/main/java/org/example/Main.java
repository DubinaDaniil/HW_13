package org.example;

import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.net.http.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Gson gson = new GsonBuilder().create();

        User userRequest = User.builder()
                .name("Daniil")
                .phone("+3805023523545")
                .build();

        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest createUser = HttpRequest.newBuilder(new URI(uri))
                .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(userRequest)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(createUser, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }
}