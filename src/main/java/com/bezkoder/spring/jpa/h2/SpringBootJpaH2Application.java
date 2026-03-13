package com.bezkoder.spring.jpa.h2;

import com.bezkoder.spring.jpa.h2.adapter.CommentAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaH2Application.class, args);
	}
	@Bean
	CommandLineRunner run(CommentAdapter commentAdapter) {
		return args -> {
			System.out.println("--- Probando Adaptador de Comentarios ---");
			commentAdapter.probarApi();
		};
	}
}
