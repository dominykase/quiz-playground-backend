package com.quizplayground.quizplayground.useCases.quiz;

import com.quizplayground.quizplayground.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.quiz.PatchQuizRequestDto;

@Service
public class UpdateQuizUseCase {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz handle(PatchQuizRequestDto requestDto) {
        return quizRepository.save(requestDto.toQuiz());
    }
}
