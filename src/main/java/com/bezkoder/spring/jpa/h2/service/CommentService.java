package com.bezkoder.spring.jpa.h2.service;


//import com.bezkoder.spring.jpa.h2.adapter.CommentAdapter;
import com.bezkoder.spring.jpa.h2.dto.CommentDto;
import com.bezkoder.spring.jpa.h2.dto.CommentFilterDto;
import com.bezkoder.spring.jpa.h2.dto.CreateCommentDto;
import com.bezkoder.spring.jpa.h2.mappers.CommentMapper;
import com.bezkoder.spring.jpa.h2.model.Comment;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.repository.CommentRepository;
import com.bezkoder.spring.jpa.h2.repository.TutorialRepository;
import com.bezkoder.spring.jpa.h2.specifications.CommentSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TutorialRepository tutorialRepository;
 //   private final CommentAdapter commentAdapter;


    public List<CommentDto> getComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::commentToCommentDto)
                .collect(Collectors.toList());
    }


    public Optional<CommentDto> getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::commentToCommentDto);
    }

    public CommentDto createComment(Long tutorialId, CreateCommentDto createCommentDto) {
        Tutorial tutorial = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new RuntimeException("Tutorial not found"));

        Comment comment = new Comment();
        comment.setContent(createCommentDto.getContent());
        comment.setAuthorName(createCommentDto.getAuthorName());
        comment.setTutorial(tutorial);
        comment.setCreatedAt(LocalDateTime.now());

        return commentMapper.commentToCommentDto(commentRepository.save(comment));
    }


    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentDto> getCommentsByTutorialId(Long tutorialId) {
        return commentRepository.findByTutorialId(tutorialId)
                .stream()
                .map(commentMapper::commentToCommentDto)
                .collect(Collectors.toList());
    }

    public Page<Comment> filterComments(CommentFilterDto filterDto) {
        Specification<Comment> spec = Specification
                .where(CommentSpecifications.authorNameLike(filterDto.getAuthorName()))
                .and(CommentSpecifications.hasTutorialId(filterDto.getTutorialId()))
                .and(CommentSpecifications.contentLike(filterDto.getContent()));

        Pageable pageable = PageRequest.of(
                filterDto.getPage(),
                filterDto.getSize(),
                Sort.by("createdAt").descending()
        );

        return commentRepository.findAll(spec, pageable);
    }
/*
    public List<CommentDto> fetchLatestComments() {
        CommentDto[] response = commentAdapter.getComments();
        return List.of(response);

    }
*/
}