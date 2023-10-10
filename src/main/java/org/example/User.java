package org.example;

import lombok.*;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String webSite;
    private Company company;
}
