package com.quizplayground.quizplayground.requestDtos.answer;

import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.Question;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PatchAnswerRequestDto extends PostAnswerRequestDto {

  @NotNull(message = "Id field is required.")
  public Long id;

  @Override
  public Answer toAnswer(Question question) {
    Answer answer = super.toAnswer(question);
    answer.setId(this.id);

    return answer;
  }
}
