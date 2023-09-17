package com.quizplayground.quizplayground.requestDtos.answer;

import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.Category;
import com.quizplayground.quizplayground.models.CategoryWeight;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PatchCategoryWeightRequestDto {

  @NotNull(message = "Id field is required.")
  public Long id;

  @NotNull(message = "Weight field is required.")
  @Min(value = 0L, message = "Weight field must be a non-negative integer.")
  public Integer weight;

  public CategoryWeight toCategoryWeight(Answer answer, Category category) {
    CategoryWeight categoryWeight = new CategoryWeight();
    categoryWeight.setAnswer(answer);
    categoryWeight.setCategory(category);
    categoryWeight.setId(this.id);
    categoryWeight.setWeight(this.weight);

    return categoryWeight;
  }
}
