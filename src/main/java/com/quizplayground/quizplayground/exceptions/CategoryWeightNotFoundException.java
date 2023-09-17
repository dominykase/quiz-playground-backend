package com.quizplayground.quizplayground.exceptions;

public class CategoryWeightNotFoundException extends RuntimeException {
  public CategoryWeightNotFoundException(Long id) {
    super("Could not find category weight by id=" + id.toString());
  }
}
