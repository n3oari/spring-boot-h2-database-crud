/*
package com.bezkoder.spring.jpa.h2.adapter;

import com.bezkoder.spring.jpa.h2.dto.CommentDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@Component
public class CommentAdapter {
    RestTemplate restTemplate = new RestTemplate();

    CommentDto[] comments = restTemplate.getForObject(
            "https://dummyjson.com/comments?limit=10", CommentDto[].class);

    public CommentDto[] getComments() {
        return comments;
    }

}


 */