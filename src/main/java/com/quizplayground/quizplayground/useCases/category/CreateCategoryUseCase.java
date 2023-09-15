package com.quizplayground.quizplayground.useCases.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.CategoryRepository;
import com.quizplayground.quizplayground.repositories.QuizRepository;
import com.quizplayground.quizplayground.requestDtos.category.PostCategoryRequestDto;

@Service
public class CreateCategoryUseCase {
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private QuizRepository quizRepository;

  public Quiz handle(Long quizId, PostCategoryRequestDto requestDto) {
    Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
    this.categoryRepository.save(requestDto.toCategory(quiz));
    this.quizRepository.refresh(quiz);

    return quiz;
  }
}
