package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.TutorialByAuthorDto;
import com.bezkoder.spring.jpa.h2.dto.TutorialDto;
import com.bezkoder.spring.jpa.h2.mappers.TutorialMapper;
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
    private final TutorialMapper tutorialMapper;


    public List<TutorialDto> getTutorials(String search) {
        List<Tutorial> tutorials;

        if (search == null || search.isEmpty()) {
            tutorials = tutorialRepository.findAll();
        } else {
            tutorials = tutorialRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(search, search);
        }


        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialDto)
                .toList();
    }

    public Optional<TutorialDto> getTutorialById(Long id) {
        return tutorialRepository.findById(id)
                .map(tutorialMapper::tutorialToTutorialDto);
    }

    public TutorialDto createTutorial(TutorialDto tutorialDto) {
        Tutorial tutorial = tutorialMapper.tutorialDtoToTutorial(tutorialDto);
        Tutorial savedTutorial = tutorialRepository.save(tutorial);
        return tutorialMapper.tutorialToTutorialDto(savedTutorial);

    }

    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }

    public List<TutorialDto> findByPublished() {

        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialDto)
                .toList();
    }

    public List<TutorialDto> getTutorialsByAuthor(Long authorId) {
        List<Tutorial> tutorials = tutorialRepository.findByAuthorId(authorId);
        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialDto)
                .toList();
    }

    public List<TutorialDto> getTutorialsByCategory(Long categoryId) {
        List<Tutorial> tutorials = tutorialRepository.findByCategoryId(categoryId);
        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialDto)
                .toList();
    }

    public TutorialDto updateTutorial(Long id, TutorialDto tutorialDto) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            tutorialMapper.updateTutorialFromDto(tutorialDto, _tutorial);
            return tutorialMapper.tutorialToTutorialDto(tutorialRepository.save(_tutorial));
        } else {
            return null;
        }
    }


    public List<TutorialDto> searchTutorials(String search) {
        List<Tutorial> tutorials = tutorialRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(search, search);

        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialDto)
                .toList();
    }

    public List<TutorialByAuthorDto> getTutorialsByAuthor(String name) {
        List<Tutorial> tutorials = tutorialRepository.findByAuthorName(name);

        return tutorials.stream()
                .map(tutorialMapper::tutorialToTutorialByAuthorDto)
                .toList();
    }


}
