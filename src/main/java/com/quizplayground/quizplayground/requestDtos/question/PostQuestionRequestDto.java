package com.quizplayground.quizplayground.requestDtos.question;

import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.models.Quiz;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostQuestionRequestDto {
  @NotNull(message = "Text field is required.")
  public String text;

  public Question toQuestion(Quiz quiz) {
    Question question = new Question();
    question.setText(this.text);
    question.setQuiz(quiz);
    return question;
  }
}
