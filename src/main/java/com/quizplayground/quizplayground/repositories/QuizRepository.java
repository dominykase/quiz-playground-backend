package com.quizplayground.quizplayground.repositories;

import com.quizplayground.quizplayground.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
