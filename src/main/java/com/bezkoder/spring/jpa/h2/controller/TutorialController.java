package com.bezkoder.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import com.bezkoder.spring.jpa.h2.dto.TutorialByAuthorDto;
import com.bezkoder.spring.jpa.h2.dto.TutorialDto;
import com.bezkoder.spring.jpa.h2.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {


    @Autowired
    private TutorialService tutorialService;


    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialDto>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<TutorialDto> tutorials = tutorialService.getTutorials(title);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable("id") long id) {
        Optional<TutorialDto> tutorialData = tutorialService.getTutorialById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<TutorialDto> createTutorial(@RequestBody TutorialDto tutorialDto) {
        try {
            TutorialDto _tutorial = tutorialService.createTutorial(tutorialDto);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<TutorialDto> updateTutorial(@PathVariable("id") long id, @RequestBody TutorialDto tutorialDto) {
        TutorialDto updatedTutorial = tutorialService.updateTutorial(id, tutorialDto);

        if (updatedTutorial != null) {
            return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialService.deleteTutorial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialService.deleteAllTutorials();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<TutorialDto>> findByPublished() {
        try {
            List<TutorialDto> tutorials = tutorialService.findByPublished();

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/by-author/{authorId}")
    public ResponseEntity<List<TutorialDto>> findByAuthorId(@PathVariable Long authorId) {
        try {
            List<TutorialDto> tutorials = tutorialService.getTutorialsByAuthor(authorId);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/tutorials/by-category/{categoryId}")
    public ResponseEntity<List<TutorialDto>> findByCategoryId(@PathVariable Long categoryId) {
        try {
            List<TutorialDto> tutorials = tutorialService.getTutorialsByCategory(categoryId);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(value = "/tutorials", params = "search")
    public ResponseEntity<List<TutorialDto>> searchTutorial(@RequestParam(required = false) String search) {
        try {

            List<TutorialDto> tutorials = tutorialService.searchTutorials(search);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/author")
    public ResponseEntity<List<TutorialByAuthorDto>> getTutorialsByAuthor(@RequestParam String name) {
        try {
            List<TutorialByAuthorDto> tutorials = tutorialService.getTutorialsByAuthor(name);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


