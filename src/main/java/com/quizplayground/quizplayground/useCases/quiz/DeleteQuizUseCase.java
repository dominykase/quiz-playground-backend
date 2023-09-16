package com.quizplayground.quizplayground.useCases.quiz;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteQuizUseCase {

  @Autowired private QuizRepository quizRepository;

  public void handle(Long quizId) {
    this.quizRepository.delete(
        this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId)));
  }
}
