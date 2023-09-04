package com.quizplayground.quizplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.requestDtos.category.CategoryPostRequestDto;
import com.quizplayground.quizplayground.useCases.category.CreateCategoryUseCase;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
  @Autowired
  private CreateCategoryUseCase createCategoryUseCase;

  @PostMapping("/quiz/{quizId}/category")
  public Quiz createInitialCategories(
      @PathVariable Long quizId,
      @RequestBody @Valid CategoryPostRequestDto requestDto) {
    return this.createCategoryUseCase.handle(quizId, requestDto);
  }
}
