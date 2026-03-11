package com.bezkoder.spring.jpa.h2.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContainingIgnoreCase(String title);

  List<Tutorial> findByAuthorId(Long authorId);

  List<Tutorial> findByCategoryId(Long categoryId);

  List<Tutorial> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

  @Query(
          value = "SELECT t FROM Tutorial t " +
                  "JOIN FETCH t.author a " +
                  "JOIN FETCH t.category c " +
                  "WHERE LOWER(a.name) = LOWER(:name)",
          countQuery = "SELECT COUNT(t) FROM Tutorial t JOIN t.author a WHERE LOWER(a.name) = LOWER(:name)"
  )
  Page<Tutorial> findByAuthorName(@Param("name") String name, Pageable pageable);

}
