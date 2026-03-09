package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.h2.model.Tutorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContainingIgnoreCase(String title);

  List<Tutorial> findByAuthorId(Long authorId);

  List<Tutorial> findByCategoryId(Long categoryId);

  List<Tutorial> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

  @Query("SELECT t FROM Tutorial t " +
          "JOIN FETCH t.author a " +
          "JOIN FETCH t.category c " +
          "WHERE LOWER(a.name) = LOWER(:name)")
  List<Tutorial> findByAuthorName(@Param("name") String name);

}
