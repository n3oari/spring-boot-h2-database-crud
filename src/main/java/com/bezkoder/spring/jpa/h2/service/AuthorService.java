package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.AuthorDto;
import com.bezkoder.spring.jpa.h2.mappers.AuthorMapper;
import com.bezkoder.spring.jpa.h2.model.Author;
import com.bezkoder.spring.jpa.h2.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    public List<AuthorDto> getAuthors(String name) {

        List<Author> authors = (name == null || name.isEmpty())
                ? authorRepository.findAll()
                : authorRepository.findByNameContainingIgnoreCase(name);

        List<AuthorDto> authorDtos = authors.stream()
                .map(authorMapper::authorToAuthorDto)
                .toList();
        return authorDtos;
    }

    public Optional<AuthorDto> getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::authorToAuthorDto);
    }

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author author = authorMapper.authorDtoToAuthor(authorDto);
        Author savedAuthor = authorRepository.save(author);

        return authorMapper.authorToAuthorDto(savedAuthor);

    }

}