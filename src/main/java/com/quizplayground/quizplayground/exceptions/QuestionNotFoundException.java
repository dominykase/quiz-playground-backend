package com.quizplayground.quizplayground.exceptions;

public class QuestionNotFoundException extends RuntimeException {
  public QuestionNotFoundException(Long id) {
    super("Could not find question by id=" + id.toString());
  }
}
