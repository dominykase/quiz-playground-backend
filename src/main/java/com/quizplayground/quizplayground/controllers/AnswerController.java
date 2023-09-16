package com.quizplayground.quizplayground.controllers;

import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.requestDtos.answer.PatchAnswerRequestDto;
import com.quizplayground.quizplayground.requestDtos.answer.PostAnswerRequestDto;
import com.quizplayground.quizplayground.useCases.answer.CreateAnswerUseCase;
import com.quizplayground.quizplayground.useCases.answer.DeleteAnswerUseCase;
import com.quizplayground.quizplayground.useCases.answer.EditAnswerUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
  @Autowired private CreateAnswerUseCase createAnswerUseCase;
  @Autowired private EditAnswerUseCase editAnswerUseCase;
  @Autowired private DeleteAnswerUseCase deleteAnswerUseCase;

  @PostMapping("/question/{questionId}/answer")
  public Quiz createAnswer(
      @PathVariable Long questionId, @RequestBody @Valid PostAnswerRequestDto requestDto) {
    return this.createAnswerUseCase.handle(questionId, requestDto);
  }

  @PatchMapping("/question/{questionId}/answer")
  public Quiz editAnswer(
      @PathVariable Long questionId, @RequestBody @Valid PatchAnswerRequestDto requestDto) {
    return this.editAnswerUseCase.handle(questionId, requestDto);
  }

  @DeleteMapping("/answer/{answerId}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteAnswer(@PathVariable Long answerId) {
    this.deleteAnswerUseCase.handle(answerId);
  }
}
