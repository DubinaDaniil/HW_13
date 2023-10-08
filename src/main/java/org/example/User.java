package org.example;

import lombok.*;
import java.util.*;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private Map<String, String> address;
    private String phone;
    private String webSite;
    private Map<String, String> company;
}
