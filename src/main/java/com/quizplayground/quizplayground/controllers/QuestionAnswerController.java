package com.quizplayground.quizplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizplayground.quizplayground.jsonResources.SubmissionResult;
import com.quizplayground.quizplayground.requestDtos.questionAnswer.PostCompleteQuizRequestDto;
import com.quizplayground.quizplayground.useCases.questionAnswer.CompleteQuizUseCase;

import jakarta.validation.Valid;

@RestController
public class QuestionAnswerController {

    @Autowired
    private CompleteQuizUseCase completeQuizUseCase;

    @PostMapping("/question/answer")
    public List<SubmissionResult> completeQuiz(@RequestBody @Valid PostCompleteQuizRequestDto requestDto) {
        return this.completeQuizUseCase.handle(requestDto);
    }
}
