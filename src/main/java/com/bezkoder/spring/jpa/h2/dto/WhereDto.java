package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WhereDto {
    private String authorName;
    private String content;
    private int tutorialId;
}
