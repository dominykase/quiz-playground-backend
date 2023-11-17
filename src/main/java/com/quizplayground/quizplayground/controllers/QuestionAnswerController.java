package com.quizplayground.quizplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quizplayground.quizplayground.requestDtos.questionAnswer.PostCompleteQuizRequestDto;
import com.quizplayground.quizplayground.useCases.questionAnswer.CompleteQuizUseCase;

import jakarta.validation.Valid;

@RestController
public class QuestionAnswerController {

    @Autowired
    private CompleteQuizUseCase completeQuizUseCase;

    @PostMapping("/question/answer")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void completeQuiz(@RequestBody @Valid PostCompleteQuizRequestDto requestDto) {
        this.completeQuizUseCase.handle(requestDto);
    }
}
