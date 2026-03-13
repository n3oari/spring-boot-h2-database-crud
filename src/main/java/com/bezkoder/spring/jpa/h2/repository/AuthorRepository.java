package com.bezkoder.spring.jpa.h2.repository;

import com.bezkoder.spring.jpa.h2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // El método debe filtrar por el campo 'name' de la entidad Author
    List<Author> findByNameContainingIgnoreCase(String name);
}