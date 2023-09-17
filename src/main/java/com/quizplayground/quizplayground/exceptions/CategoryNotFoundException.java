package com.quizplayground.quizplayground.exceptions;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(Long id) {
    super("Could not find category by id=" + id.toString());
  }
}
