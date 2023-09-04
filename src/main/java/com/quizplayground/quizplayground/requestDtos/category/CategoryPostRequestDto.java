package com.quizplayground.quizplayground.requestDtos.category;

import com.quizplayground.quizplayground.models.Category;
import com.quizplayground.quizplayground.models.Quiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CategoryPostRequestDto {
  @NotNull(message = "Category name field is required.")
  public String name;

  public Category toCategory(Quiz quiz) {
    Category category = new Category();
    category.setName(this.name);
    category.setQuiz(quiz);
    return category;
  }
}
