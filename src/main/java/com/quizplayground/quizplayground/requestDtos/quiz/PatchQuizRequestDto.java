package com.quizplayground.quizplayground.requestDtos.quiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.quizplayground.quizplayground.models.Quiz;

@AllArgsConstructor
@NoArgsConstructor
public class PatchQuizRequestDto extends PostQuizRequestDto {
    @NotNull(message = "Id field is required.")
    public Long id;

    @Override
    public Quiz toQuiz() {
        Quiz quiz = super.toQuiz();
        quiz.setId(this.id);
        return quiz;
    }
}
