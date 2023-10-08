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
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createUser = HttpRequest.newBuilder(new URI(uri + "/users"))
                .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(userRequest)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = httpClient.send(createUser, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
        System.out.println();

        User updateUserBody = User.builder()
                .userName("I7Pi3PAk")
                .build();
        HttpRequest updateUserRequest = HttpRequest.newBuilder(new URI(uri + "/users/" + 10))
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(updateUserBody)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> updateResponse = httpClient.send(updateUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("updateResponse.statusCode() = " + updateResponse.statusCode());
        System.out.println("updateResponse.body() = " + updateResponse.body());
        System.out.println();

        HttpRequest deleteUserRequest = HttpRequest.newBuilder(new URI(uri + "/users/" + 10))
                .DELETE()
                .build();
        HttpResponse<String> deleteResponse = httpClient.send(deleteUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("deleteResponse.statusCode() = " + deleteResponse.statusCode());
        System.out.println();

        HttpRequest getAllCustomers = HttpRequest.newBuilder(new URI(uri + "/users"))
                .GET()
                .build();
        HttpResponse<String> getAllCustomersResponse = httpClient.send(getAllCustomers, HttpResponse.BodyHandlers.ofString());
        System.out.println("getAllCustomersResponse.statusCode() = " + getAllCustomersResponse.statusCode());
        System.out.println("getAllCustomersResponse.body() = " + getAllCustomersResponse.body());
        System.out.println();

        HttpRequest getCustomerById = HttpRequest.newBuilder(new URI(uri + "/users/1"))
                .GET()
                .build();
        HttpResponse<String> getCustomerByIdResponse = httpClient.send(getCustomerById, HttpResponse.BodyHandlers.ofString());
        System.out.println("getCustomerByIdResponse.statusCode() = " + getCustomerByIdResponse.statusCode());
        System.out.println("getCustomerByIdResponse.body() = " + getCustomerByIdResponse.body());
        System.out.println();

        HttpRequest getCustomerByUsername = HttpRequest.newBuilder(new URI(uri + "/users?username=Bret"))
                .GET()
                .build();
        HttpResponse<String> getCustomerByUsernameResponse = httpClient.send(getCustomerByUsername, HttpResponse.BodyHandlers.ofString());
        System.out.println("getCustomerByUsernameResponse.statusCode() = " + getCustomerByUsernameResponse.statusCode());
        System.out.println("getCustomerByUsernameResponse.body() = " + getCustomerByUsernameResponse.body());
        System.out.println();

    }
}