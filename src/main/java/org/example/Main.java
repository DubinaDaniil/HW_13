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
                .phone("+380502352354")
                .build();

        String uri = "https://jsonplaceholder.typicode.com";
        HttpRequest createUser = HttpRequest.newBuilder(new URI(uri))
                .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(userRequest)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(createUser, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
        System.out.println();

        User updateUserBody = User.builder()
                .userName("I7Pi3PAk")
                .build();
        HttpRequest updateUserRequest = HttpRequest.newBuilder(new URI(uri + "/users" + 10))
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(updateUserBody)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> updateResponse = httpClient.send(updateUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("updateResponse.statusCode() = " + updateResponse.statusCode());
        System.out.println("updateResponse.body() = " + updateResponse.body());
        System.out.println();

        HttpRequest deleteUserRequest = HttpRequest.newBuilder(new URI(uri + "/users" + 10))
                .DELETE()
                .build();
        HttpResponse<String> deleteResponse = httpClient.send(deleteUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("deleteResponse.statusCode() = " + deleteResponse.statusCode());
        System.out.println();

        HttpRequest getAllCustomers = HttpRequest.newBuilder(new URI(uri+ "/users"))
                .GET()
                .build();
        HttpResponse<String> getAllCustomersResponse = httpClient.send(getAllCustomers, HttpResponse.BodyHandlers.ofString());
        System.out.println("getAllCustomersResponse.statusCode() = " + getAllCustomersResponse.statusCode());
        System.out.println("getAllCustomersResponse.body() = " + getAllCustomersResponse.body());
        System.out.println();


    }
}