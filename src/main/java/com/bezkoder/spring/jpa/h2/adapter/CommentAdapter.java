
package com.bezkoder.spring.jpa.h2.adapter;


import com.bezkoder.spring.jpa.h2.dto.DummyJsonResponseDto;
import com.bezkoder.spring.jpa.h2.dto.UserCommentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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

    public List<UserCommentDto> obtenerComentariosMapeados() {
        String url = "https://dummyjson.com/comments?limit=10";

        try {

            DummyJsonResponseDto response = restTemplate.getForObject(url, DummyJsonResponseDto.class);

            if (response != null && response.getComments() != null) {
                List<UserCommentDto> lista = response.getComments();

                System.out.println("\n>>> MOSTRANDO DATOS MAPEADOS (DTO) <<<");
                for (UserCommentDto dto : lista) {

                    System.out.println(String.format(
                            "Comentario [%d] | Usuario: %s (%s) | Likes: %d | Post: %d",
                            dto.getId(),
                            dto.getUser().getUsername(),
                            dto.getUser().getFullName(),
                            dto.getLikes(),
                            dto.getPostId()
                    ));
                }

                return lista;
            }
        } catch (Exception e) {
            System.err.println("Error: No se pudo mapear el JSON a los DTOs. " + e.getMessage());
        }

        return List.of();
    }

}