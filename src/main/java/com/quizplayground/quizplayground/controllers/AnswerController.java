package com.quizplayground.quizplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.requestDtos.answer.PostAnswerRequestDto;
import com.quizplayground.quizplayground.useCases.answer.CreateAnswerUseCase;

import jakarta.validation.Valid;

@RestController
public class AnswerController {
  @Autowired
  private CreateAnswerUseCase createAnswerUseCase;

  @PostMapping("/question/{questionId}/answer")
  public Question createAnswer(
      @PathVariable Long questionId, @RequestBody @Valid PostAnswerRequestDto requestDto) {
    return this.createAnswerUseCase.handle(questionId, requestDto);
  }
}
