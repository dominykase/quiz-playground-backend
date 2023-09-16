package com.quizplayground.quizplayground.useCases.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.QuestionNotFoundException;
import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.repositories.AnswerRepository;
import com.quizplayground.quizplayground.repositories.QuestionRepository;
import com.quizplayground.quizplayground.requestDtos.answer.PostAnswerRequestDto;

@Service
public class CreateAnswerUseCase {

  @Autowired
  private QuestionRepository questionRepository;
  @Autowired
  private AnswerRepository answerRepository;

  public Question handle(Long questionId, PostAnswerRequestDto requestDto) {
    Question question = this.questionRepository.findById(questionId)
        .orElseThrow(() -> new QuestionNotFoundException(questionId));
    this.answerRepository.save(requestDto.toAnswer(question));
    this.questionRepository.refresh(question);

    return question;
  }
}
