package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.TutorialDto;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.repository.AuthorRepository;
import com.bezkoder.spring.jpa.h2.repository.CategoryRepository;
import com.bezkoder.spring.jpa.h2.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public List<Tutorial> getTutorials(String title) {
        if (title == null || title.isEmpty()) {
            return tutorialRepository.findAll();
        }
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    public Optional<Tutorial> getTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial createTutorial(TutorialDto tutorialDto) {
        Tutorial tutorial = new Tutorial();

        tutorial.setTitle(tutorialDto.getTitle());
        tutorial.setDescription(tutorialDto.getDescription());
        tutorial.setPublished(tutorialDto.isPublished());
        tutorial.setAuthor(authorRepository.getReferenceById(tutorialDto.getAuthorId()));
        tutorial.setCategory(categoryRepository.getReferenceById(tutorialDto.getCategoryId()));
        return tutorialRepository.save(tutorial);
    }

    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }

    public List<Tutorial> findByPublished() {
        return tutorialRepository.findByPublished(true);
    }

    public List<Tutorial> getTutorialsByAuthor(Long authorId) {
        return tutorialRepository.findByAuthorId(authorId);
    }

    public List<Tutorial> getTutorialsByCategory(Long categoryId)
        {
        return tutorialRepository.findByCategoryId(categoryId);
    }

    public Tutorial updateTutorial(Long id, TutorialDto tutorialDto) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorialDto.getTitle());
            _tutorial.setDescription(tutorialDto.getDescription());
            _tutorial.setPublished(tutorialDto.isPublished());
            return tutorialRepository.save(_tutorial);
        } else {
            return null;
        }
    }


}
