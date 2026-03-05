package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.AuthorDto;
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


    public List<Author> getAuthors(String name) {
        if (name == null || name.isEmpty()) {
            return authorRepository.findAll();
        }
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(AuthorDto authorDto) {
        Author author = new Author();

        author.setName(authorDto.getName());
        author.setLastName(authorDto.getLastName());
        author.setEmail(authorDto.getEmail());
        author.setAge(authorDto.getAge());

        return authorRepository.save(author);
    }

}