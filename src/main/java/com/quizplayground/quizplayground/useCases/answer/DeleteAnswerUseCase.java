package com.quizplayground.quizplayground.useCases.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.AnswerNotFoundException;
import com.quizplayground.quizplayground.repositories.AnswerRepository;

@Service
public class DeleteAnswerUseCase {

  @Autowired
  private AnswerRepository answerRepository;

  public void handle(Long answerId) {
    this.answerRepository.delete(
        this.answerRepository.findById(answerId)
            .orElseThrow(() -> new AnswerNotFoundException(answerId)));
  }
}
