package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {
    private String name;
    private String description;
}
