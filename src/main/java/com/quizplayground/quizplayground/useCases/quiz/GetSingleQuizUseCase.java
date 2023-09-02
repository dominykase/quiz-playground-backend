package com.quizplayground.quizplayground.useCases.quiz;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class GetSingleQuizUseCase {
    private final QuizRepository quizRepository;

    public GetSingleQuizUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz handle(Long quizId) {
        return this.quizRepository
                .findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException(quizId));
    }
}
