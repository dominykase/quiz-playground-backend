package com.quizplayground.quizplayground.useCases.quiz;

import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllQuizzesUseCase {
    private final QuizRepository quizRepository;

    public GetAllQuizzesUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> handle() {
        return this.quizRepository.findAll();
    }
}
