package org.example;

import lombok.*;

@Data
public class Address {

   private String street;
   private String suite;
   private String city;
   private String zipcode;
   private Geo geo;
}
