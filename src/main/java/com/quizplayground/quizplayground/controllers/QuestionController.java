package com.quizplayground.quizplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.requestDtos.question.PatchQuestionRequestDto;
import com.quizplayground.quizplayground.requestDtos.question.PostQuestionRequestDto;
import com.quizplayground.quizplayground.useCases.question.CreateQuestionUseCase;
import com.quizplayground.quizplayground.useCases.question.EditQuestionUseCase;

import jakarta.validation.Valid;

@RestController
public class QuestionController {

  @Autowired
  private CreateQuestionUseCase createQuestionUseCase;
  @Autowired
  private EditQuestionUseCase editQuestionUseCase;

  @PostMapping("/quiz/{quizId}/question")
  public Quiz createQuestion(
      @PathVariable Long quizId,
      @RequestBody @Valid PostQuestionRequestDto requestDto) {
    return this.createQuestionUseCase.handle(quizId, requestDto);
  }

  @PatchMapping("/quiz/{quizId}/question")
  public Quiz editQuestion(
      @PathVariable Long quizId,
      @RequestBody @Valid PatchQuestionRequestDto requestDto) {
    return this.editQuestionUseCase.handle(quizId, requestDto);
  }
}
