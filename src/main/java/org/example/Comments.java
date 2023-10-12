package org.example;

import lombok.*;

import java.io.*;

@Data
public class Comments implements Serializable {

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
}
