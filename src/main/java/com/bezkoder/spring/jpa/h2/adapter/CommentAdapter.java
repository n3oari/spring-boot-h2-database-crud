
package com.bezkoder.spring.jpa.h2.adapter;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class CommentAdapter {
    private final RestTemplate restTemplate = new RestTemplate();

    public void probarApi() {
        String url = "https://dummyjson.com/comments?limit=10";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null) {
            System.out.println("¡Conexión exitosa!");
            System.out.println("Datos recibidos: " + response.get("comments"));
        }
    }
}