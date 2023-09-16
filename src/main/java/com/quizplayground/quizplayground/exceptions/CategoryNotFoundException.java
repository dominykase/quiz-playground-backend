package com.quizplayground.quizplayground.exceptions;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(Long id) {
    super("Could not find cateogory by id=" + id.toString());
  }
}
