package com.bezkoder.spring.jpa.h2.service;


//import com.bezkoder.spring.jpa.h2.adapter.CommentAdapter;

import com.bezkoder.spring.jpa.h2.adapter.CommentAdapter;
import com.bezkoder.spring.jpa.h2.dto.CommentDto;
import com.bezkoder.spring.jpa.h2.dto.CommentFilterDto;
import com.bezkoder.spring.jpa.h2.dto.CreateCommentDto;
import com.bezkoder.spring.jpa.h2.dto.UserCommentDto;
import com.bezkoder.spring.jpa.h2.mappers.CommentMapper;
import com.bezkoder.spring.jpa.h2.model.Author;
import com.bezkoder.spring.jpa.h2.model.Comment;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.model.Users;
import com.bezkoder.spring.jpa.h2.repository.*;
import com.bezkoder.spring.jpa.h2.specifications.CommentSpecifications;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bezkoder.spring.jpa.h2.model.Category;
import com.bezkoder.spring.jpa.h2.repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TutorialRepository tutorialRepository;
    private final UserRepository userRepository;
    private final CommentAdapter commentAdapter;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

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
                .orElseThrow(() -> new EntityNotFoundException("Tutorial not found"));

        Users user = userRepository.findById(createCommentDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Comment comment = new Comment();
        comment.setContent(createCommentDto.getContent());
        comment.setUser(user);
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


    @Transactional
    public void guardarComentariosDeApi() {
        List<UserCommentDto> comentariosApi = commentAdapter.obtenerComentariosMapeados();

        if (comentariosApi.isEmpty()) {
            System.out.println("No se encontraron comentarios en la API.");
            return;
        }


        Category categoriaSistema = categoryRepository.findAll().stream().findFirst()
                .orElseGet(() -> {
                    Category c = new Category();
                    c.setName("General API");
                    return categoryRepository.save(c);
                });

        Author autorSistema = authorRepository.findAll().stream().findFirst()
                .orElseGet(() -> {
                    Author a = new Author();
                    a.setName("Sistema");
                    a.setLastName("Automático");
                    a.setEmail("admin@api.com");
                    a.setAge(99);
                    return authorRepository.save(a);
                });


        Tutorial tutorialGenerico = tutorialRepository.findAll().stream().findFirst()
                .orElseGet(() -> {
                    Tutorial t = new Tutorial();
                    t.setTitle("API Import");
                    t.setDescription("Tutorial contenedor para comentarios de DummyJSON");
                    t.setPublished(true);
                    t.setAuthor(autorSistema);
                    t.setCategory(categoriaSistema);
                    return tutorialRepository.save(t);
                });


        int procesados = 0;
        for (UserCommentDto dto : comentariosApi) {
            try {

                Users user = userRepository.findByUsername(dto.getUser().getUsername())
                        .orElseGet(() -> {
                            Users newUser = new Users();
                            newUser.setUsername(dto.getUser().getUsername());
                            newUser.setFullName(dto.getUser().getFullName());
                            return userRepository.save(newUser);
                        });


                Comment commentEntity = new Comment();
                commentEntity.setContent(dto.getBody());
                commentEntity.setUser(user);
                commentEntity.setTutorial(tutorialGenerico);
                commentEntity.setCreatedAt(LocalDateTime.now());


                commentRepository.save(commentEntity);
                procesados++;

            } catch (Exception e) {
                System.err.println("Error procesando comentario " + dto.getId() + ": " + e.getMessage());
            }
        }

        System.out.println("Sincronización finalizada: " + procesados + " comentarios guardados.");
    }
    public String exportarComentariosCsv(Long tutorialId) {
        List<Comment> comentarios = commentRepository.findByTutorialId(tutorialId);
        StringBuilder csv = new StringBuilder();

        csv.append("ID;Usuario;Contenido;Fecha\n");

        for (Comment c : comentarios) {
            csv.append(c.getId()).append(";")
                    .append(c.getUser().getUsername()).append(";")
                    .append(c.getContent().replace("\n", " ")).append(";")
                    .append(c.getCreatedAt()).append("\n");
        }

        return csv.toString();
    }


}


