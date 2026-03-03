package com.bezkoder.spring.jpa.h2;

import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.repository.TutorialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final TutorialRepository tutorialRepository;

    public DataLoader(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public void run(String... args) {
        tutorialRepository.save(new Tutorial("Spring Boot", "Curso básico de Spring Boot", true));
        tutorialRepository.save(new Tutorial("JUnit Testing", "Pruebas unitarias en Java", false));
        tutorialRepository.save(new Tutorial("Mockito", "Mocking en Java", true));
        tutorialRepository.save(new Tutorial("REST APIs", "Creando servicios REST", true));
        tutorialRepository.save(new Tutorial("Spring Data JPA", "Trabajando con repositorios", false));
    }
}