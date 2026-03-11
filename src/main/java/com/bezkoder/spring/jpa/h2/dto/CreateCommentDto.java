package com.bezkoder.spring.jpa.h2.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCommentDto
{
    private String authorName;
    private String content;
}
