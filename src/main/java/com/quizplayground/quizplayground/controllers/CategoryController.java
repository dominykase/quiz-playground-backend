package com.quizplayground.quizplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.requestDtos.category.PostCategoryRequestDto;
import com.quizplayground.quizplayground.requestDtos.category.PatchCategoryRequestDto;
import com.quizplayground.quizplayground.useCases.category.CreateCategoryUseCase;
import com.quizplayground.quizplayground.useCases.category.EditCategoryUseCase;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
  @Autowired
  private CreateCategoryUseCase createCategoryUseCase;
  @Autowired
  private EditCategoryUseCase editCategoryUseCase;

  @PostMapping("/quiz/{quizId}/category")
  public Quiz createCategory(
      @PathVariable Long quizId,
      @RequestBody @Valid PostCategoryRequestDto requestDto) {
    return this.createCategoryUseCase.handle(quizId, requestDto);
  }

  @PatchMapping("/quiz/{quizId}/category")
  public Quiz editCategory(
      @PathVariable Long quizId,
      @RequestBody @Valid PatchCategoryRequestDto requestDto) {
    return this.editCategoryUseCase.handle(quizId, requestDto);
  }
}
