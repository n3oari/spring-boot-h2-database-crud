/*package com.bezkoder.spring.jpa.h2;

import com.bezkoder.spring.jpa.h2.model.Author;
import com.bezkoder.spring.jpa.h2.model.Category;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.repository.AuthorRepository;
import com.bezkoder.spring.jpa.h2.repository.TutorialRepository;
import com.bezkoder.spring.jpa.h2.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final TutorialRepository tutorialRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public DataLoader(TutorialRepository tutorialRepository,
                      CategoryRepository categoryRepository,
                      AuthorRepository authorRepository) {
        this.tutorialRepository = tutorialRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;

    }

    @Override
    public void run(String... args) {
        tutorialRepository.save(new Tutorial("Spring Boot", "Curso básico de Spring Boot", true));
        tutorialRepository.save(new Tutorial("JUnit Testing", "Pruebas unitarias en Java", false));
        tutorialRepository.save(new Tutorial("Mockito", "Mocking en Java", true));
        tutorialRepository.save(new Tutorial("REST APIs", "Creando servicios REST", true));
        tutorialRepository.save(new Tutorial("Spring Data JPA", "Trabajando con repositorios", false));


        categoryRepository.save(new Category("Backend", "Tecnologías del lado del servidor"));
        categoryRepository.save(new Category("Frontend", "Interfaces y frameworks visuales"));
        categoryRepository.save(new Category("Database", "Gestión de persistencia de datos"));
        categoryRepository.save(new Category("DevOps", "Automatización y despliegue"));
        categoryRepository.save(new Category("Testing", "Pruebas unitarias y de integración"));

        Author author = new Author();
        author.setName("Gabriel");
        author.setLastName("García Márquez");
        author.setAge(87);

        authorRepository.save(author);

    }
}
*/
