package com.quizplayground.quizplayground.requestDtos.answer;

import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.Question;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostAnswerRequestDto {

  @NotNull(message = "Text field is required.")
  public String text;

  public Answer toAnswer(Question question) {
    Answer answer = new Answer();
    answer.setText(this.text);
    answer.setQuestion(question);

    return answer;
  }
}
