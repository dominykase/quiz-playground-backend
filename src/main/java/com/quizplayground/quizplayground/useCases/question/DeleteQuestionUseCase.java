package com.quizplayground.quizplayground.useCases.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.QuestionNotFoundException;
import com.quizplayground.quizplayground.repositories.QuestionRepository;

@Service
public class DeleteQuestionUseCase {

  @Autowired
  private QuestionRepository questionRepository;

  public void handle(Long questionId) {
    this.questionRepository.delete(
        this.questionRepository.findById(questionId)
            .orElseThrow(() -> new QuestionNotFoundException(questionId)));
  }
}
