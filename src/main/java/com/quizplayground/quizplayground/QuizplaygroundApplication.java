package com.quizplayground.quizplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.quizplayground.quizplayground.repositories.CustomRepositoryImplementation;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImplementation.class)
public class QuizplaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizplaygroundApplication.class, args);
	}

}
