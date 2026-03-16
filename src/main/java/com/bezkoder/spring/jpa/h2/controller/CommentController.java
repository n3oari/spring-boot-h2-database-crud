package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.dto.CommentDto;
import com.bezkoder.spring.jpa.h2.dto.CommentFilterDto;
import com.bezkoder.spring.jpa.h2.dto.CreateCommentDto;
import com.bezkoder.spring.jpa.h2.model.Comment;
import com.bezkoder.spring.jpa.h2.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        try {
            List<CommentDto> comments = commentService.getComments();

            if (comments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
        try {
            Optional<CommentDto> comment = commentService.getCommentById(id);

            if (comment.isPresent()) {
                return new ResponseEntity<>(comment.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable Long tutorialId,
            @RequestBody CreateCommentDto createCommentDto) {
        try {
            CommentDto created = commentService.createComment(tutorialId, createCommentDto);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByTutorial(@PathVariable Long tutorialId) {
        try {
            List<CommentDto> comments = commentService.getCommentsByTutorialId(tutorialId);

            if (comments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/comments/filter")
    public ResponseEntity<Page<Comment>> filterComments(@RequestBody CommentFilterDto filterDto) {
        try {
            Page<Comment> comments = commentService.filterComments(filterDto);

            if (comments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/import/comments")
    public ResponseEntity<String> importComments() {
        return null;
    }

    @GetMapping("/tutorials/{id}/comments/export-csv")
    public ResponseEntity<byte[]> exportCommentsToCsv(@PathVariable Long id) {

        String csvData = commentService.exportarComentariosCsv(id);
        byte[] out = csvData.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));

        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename("comentarios_tutorial_" + id + ".csv")
                        .build()
        );

        return new ResponseEntity<>(out, headers, HttpStatus.OK);
    }

    @GetMapping("/sync/external")
    public String sync() {
        commentService.guardarComentariosDeApi();
        return "Sincronización completada con éxito.";
    }

}
