package org.example;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;

public class Main {

    public static final String URI = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

// ---------------------------------------------------TASK 1------------------------------------------------------------

        Gson gson = new GsonBuilder().create();

        User userRequest = User.builder()
                .name("Daniil")
                .phone("+380502352354")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createUser = HttpRequest.newBuilder(new URI(URI + "/users"))
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
        HttpRequest updateUserRequest = HttpRequest.newBuilder(new URI(URI + "/users/" + 10))
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(updateUserBody)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> updateResponse = httpClient.send(updateUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("updateResponse.statusCode() = " + updateResponse.statusCode());
        System.out.println("updateResponse.body() = " + updateResponse.body());
        System.out.println();

        HttpRequest deleteUserRequest = HttpRequest.newBuilder(new URI(URI + "/users/" + 10))
                .DELETE()
                .build();
        HttpResponse<String> deleteResponse = httpClient.send(deleteUserRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("deleteResponse.statusCode() = " + deleteResponse.statusCode());
        System.out.println();

        HttpRequest getAllCustomers = HttpRequest.newBuilder(new URI(URI + "/users"))
                .GET()
                .build();
        HttpResponse<String> getAllCustomersResponse = httpClient.send(getAllCustomers, HttpResponse.BodyHandlers.ofString());
        System.out.println("getAllCustomersResponse.statusCode() = " + getAllCustomersResponse.statusCode());
        System.out.println("getAllCustomersResponse.body() = " + getAllCustomersResponse.body());
        System.out.println();

        HttpRequest getCustomerById = HttpRequest.newBuilder(new URI(URI + "/users/" + 1))
                .GET()
                .build();
        HttpResponse<String> getCustomerByIdResponse = httpClient.send(getCustomerById, HttpResponse.BodyHandlers.ofString());
        System.out.println("getCustomerByIdResponse.statusCode() = " + getCustomerByIdResponse.statusCode());
        System.out.println("getCustomerByIdResponse.body() = " + getCustomerByIdResponse.body());
        System.out.println();

        HttpRequest getCustomerByUsername = HttpRequest.newBuilder(new URI(URI + "/users?username=Bret"))
                .GET()
                .build();
        HttpResponse<String> getCustomerByUsernameResponse = httpClient.send(getCustomerByUsername, HttpResponse.BodyHandlers.ofString());
        System.out.println("getCustomerByUsernameResponse.statusCode() = " + getCustomerByUsernameResponse.statusCode());
        System.out.println("getCustomerByUsernameResponse.body() = " + getCustomerByUsernameResponse.body());
        System.out.println();


// ---------------------------------------------------TASK 2------------------------------------------------------------









// ---------------------------------------------------TASK 3------------------------------------------------------------
        HttpRequest getUserTodos = HttpRequest.newBuilder(new URI(URI + "/users/1/todos"))
                .GET()
                .build();
        HttpResponse<String> getUserTodosResponse = httpClient.send(getUserTodos, HttpResponse.BodyHandlers.ofString());
        System.out.println("getUserTodosResponse.statusCode() = " + getUserTodosResponse.statusCode());
        System.out.println("getUserTodosResponse.body() = " + getUserTodosResponse.body());
        String strings = getUserTodosResponse.body();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Todos> todosList = objectMapper.readValue(strings, new TypeReference<List<Todos>>() {});
        System.out.println(todosList.stream().filter(todos -> todos.getCompleted().equals(false)).toList());
    }
}