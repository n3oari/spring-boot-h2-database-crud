package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TutorialDto {

    private String title;
    private String description;
    private boolean published;
    private Long authorId;
    private Long categoryId;
}
