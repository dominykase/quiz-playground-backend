package com.quizplayground.quizplayground.requestDtos.question;

import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.models.Quiz;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PatchQuestionRequestDto extends PostQuestionRequestDto {
  @NotNull(message = "Id field is required.")
  public Long id;

  @Override
  public Question toQuestion(Quiz quiz) {
    Question question = super.toQuestion(quiz);
    question.setId(this.id);
    return question;
  }
}
