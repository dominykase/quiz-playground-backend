package com.quizplayground.quizplayground.useCases.answer;

import com.quizplayground.quizplayground.exceptions.QuestionNotFoundException;
import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.Category;
import com.quizplayground.quizplayground.models.CategoryWeight;
import com.quizplayground.quizplayground.models.Question;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.AnswerRepository;
import com.quizplayground.quizplayground.repositories.CategoryWeightRepository;
import com.quizplayground.quizplayground.repositories.QuestionRepository;
import com.quizplayground.quizplayground.requestDtos.answer.PostAnswerRequestDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAnswerUseCase {

  @Autowired private QuestionRepository questionRepository;
  @Autowired private AnswerRepository answerRepository;
  @Autowired private CategoryWeightRepository categoryWeightRepository;

  public Quiz handle(Long questionId, PostAnswerRequestDto requestDto) {
    Question question =
        this.questionRepository
            .findById(questionId)
            .orElseThrow(() -> new QuestionNotFoundException(questionId));
    Answer answer = this.answerRepository.save(requestDto.toAnswer(question));

    List<Category> categories = question.getQuiz().getCategories();

    categories.forEach(
        (category) -> {
          CategoryWeight categoryWeight = new CategoryWeight();
          categoryWeight.setAnswer(answer);
          categoryWeight.setCategory(category);
          categoryWeight.setWeight(1);
          this.categoryWeightRepository.save(categoryWeight);
        });

    this.questionRepository.refresh(question);
    this.answerRepository.refresh(answer);

    return question.getQuiz();
  }
}
