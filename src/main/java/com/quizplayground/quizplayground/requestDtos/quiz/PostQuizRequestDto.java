package com.quizplayground.quizplayground.requestDtos.quiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.quizplayground.quizplayground.models.Quiz;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostQuizRequestDto {
    @NotNull(message = "Name field is required.")
    public String name;
    @NotNull(message = "Description field is required.")
    public String description;

    public Quiz toQuiz() {
        Quiz quiz = new Quiz();
        quiz.setName(this.name);
        quiz.setDescription(this.description);
        return quiz;
    }
}
