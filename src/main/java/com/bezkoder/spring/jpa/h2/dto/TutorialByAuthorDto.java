package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TutorialByAuthorDto {
    private int tutorialId;
    private int authorId;
    private int categoryId;

    private String tutorialName;
    private String authorName;
    private String categoryName;
}
