package com.bezkoder.spring.jpa.h2.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthorDto {
    private String name;
    private String lastName;
    private String email;
    private int age;
}
