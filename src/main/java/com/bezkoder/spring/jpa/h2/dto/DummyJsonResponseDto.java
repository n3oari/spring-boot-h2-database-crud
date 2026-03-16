package com.bezkoder.spring.jpa.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DummyJsonResponseDto {
    private List<UserCommentDto> comments;
    private int total;
    private int skip;
    private int limit;
}
