package com.bezkoder.spring.jpa.h2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestFilterDto {
    private int limit;
    private int offset;
    private String search;
    private WhereDto where;
}
