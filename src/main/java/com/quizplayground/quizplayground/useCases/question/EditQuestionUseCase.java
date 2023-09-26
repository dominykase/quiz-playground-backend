package com.quizplayground.quizplayground.useCases.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuestionRepository;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.question.PatchQuestionRequestDto;

@Service
public class EditQuestionUseCase {

  @Autowired
  private QuizRepository quizRepository;
  @Autowired
  private QuestionRepository questionRepository;

  public Quiz handle(Long quizId, PatchQuestionRequestDto requestDto) {
    Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
    Question question = requestDto.toQuestion(quiz);
    question = this.questionRepository.save(question);
    this.questionRepository.refresh(question);
    this.quizRepository.refresh(quiz);
    return quiz;
  }
}
