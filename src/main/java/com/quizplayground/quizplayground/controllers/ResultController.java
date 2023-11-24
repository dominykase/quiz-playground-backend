package com.quizplayground.quizplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quizplayground.quizplayground.jsonResources.results.FrequenciesQuestion;
import com.quizplayground.quizplayground.useCases.results.GetQuizResultsUseCase;

@RestController
public class ResultController {
    @Autowired
    private GetQuizResultsUseCase getQuizResultsUseCase;

    @GetMapping("/quiz/{quizId}/results")
    public List<FrequenciesQuestion> getQuizResult(@PathVariable Long quizId) {
        return this.getQuizResultsUseCase.handle(quizId);
    }
}
