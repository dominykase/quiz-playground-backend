package com.quizplayground.quizplayground.useCases.quiz;

import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.quiz.PostQuizRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CreateQuizUseCase {
    private final QuizRepository quizRepository;

    public CreateQuizUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz handle(PostQuizRequestDto requestDto) {
        Quiz newQuiz = new Quiz();
        newQuiz.setName(requestDto.name);
        newQuiz.setDescription(requestDto.description);

        return this.quizRepository.save(newQuiz);
    }
}
