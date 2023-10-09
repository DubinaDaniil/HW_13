package org.example;

import lombok.*;

@Data
@Getter
@Setter
public class Todos {

    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;

}
