package com.quizplayground.quizplayground.useCases.category;

import com.quizplayground.quizplayground.exceptions.CategoryNotFoundException;
import com.quizplayground.quizplayground.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryUseCase {

  @Autowired private CategoryRepository categoryRepository;

  public void handle(Long categoryId) {
    this.categoryRepository.delete(
        this.categoryRepository
            .findById(categoryId)
            .orElseThrow(() -> new CategoryNotFoundException(categoryId)));
  }
}
