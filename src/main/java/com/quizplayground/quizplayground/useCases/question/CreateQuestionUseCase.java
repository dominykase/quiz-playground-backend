package com.quizplayground.quizplayground.useCases.question;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuestionRepository;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.question.PostQuestionRequestDto;

import java.util.List;

@Service
public class CreateQuestionUseCase {

  @Autowired
  private QuizRepository quizRepository;
  @Autowired
  private QuestionRepository questionRepository;

  public Quiz handle(Long quizId, PostQuestionRequestDto requestDto) {
    Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
    Question question = requestDto.toQuestion(quiz);
    List<Answer> emptyAnswers = new ArrayList<Answer>();
    question.setAnswers(emptyAnswers);
    this.questionRepository.save(question);
    this.quizRepository.refresh(quiz);

    return quiz;
  }
}
