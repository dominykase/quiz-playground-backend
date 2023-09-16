package com.quizplayground.quizplayground.exceptions;

public class AnswerNotFoundException extends RuntimeException {

  public AnswerNotFoundException(Long id) {
    super("Could not find answer by id=" + id.toString());
  }
}
