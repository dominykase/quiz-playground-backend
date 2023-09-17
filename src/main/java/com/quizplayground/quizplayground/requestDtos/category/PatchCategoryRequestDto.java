package com.quizplayground.quizplayground.requestDtos.category;

import com.quizplayground.quizplayground.models.Category;
import com.quizplayground.quizplayground.models.Quiz;
import jakarta.validation.constraints.NotNull;

public class PatchCategoryRequestDto extends PostCategoryRequestDto {
  @NotNull(message = "Id field is required.")
  public Long id;

  @Override
  public Category toCategory(Quiz quiz) {
    Category category = super.toCategory(quiz);
    category.setId(this.id);

    return category;
  }
}
