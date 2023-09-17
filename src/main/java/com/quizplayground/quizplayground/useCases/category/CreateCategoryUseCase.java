package com.quizplayground.quizplayground.useCases.category;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.models.Category;
import com.quizplayground.quizplayground.models.CategoryWeight;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.AnswerRepository;
import com.quizplayground.quizplayground.repositories.CategoryRepository;
import com.quizplayground.quizplayground.repositories.CategoryWeightRepository;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.category.PostCategoryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private QuizRepository quizRepository;
  @Autowired
  private CategoryWeightRepository categoryWeightRepository;
  @Autowired
  private AnswerRepository answerRepository;

  public Quiz handle(Long quizId, PostCategoryRequestDto requestDto) {
    Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
    Category category = this.categoryRepository.save(requestDto.toCategory(quiz));

    quiz.getQuestions()
        .forEach(
            (question) -> {
              question
                  .getAnswers()
                  .forEach(
                      (answer) -> {
                        CategoryWeight categoryWeight = new CategoryWeight();
                        categoryWeight.setAnswer(answer);
                        categoryWeight.setCategory(category);
                        categoryWeight.setWeight(1);

                        this.categoryWeightRepository.save(categoryWeight);
                        this.answerRepository.refresh(answer);
                      });
            });

    this.quizRepository.refresh(quiz);

    return quiz;
  }
}
