package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int id;
    private String username;
    private String fullName;

}
