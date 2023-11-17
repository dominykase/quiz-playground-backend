package com.quizplayground.quizplayground.requestDtos.questionAnswer;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostCompleteQuizRequestDto {
    @NotNull(message = "quizId field is required")
    public Long quizId;
    
    @NotNull(message = "questionAnswers field is required")
    @NotEmpty(message = "questionAnswers field cannot be empty")
    public List<QuestionAnswerDto> questionAnswers;
}
