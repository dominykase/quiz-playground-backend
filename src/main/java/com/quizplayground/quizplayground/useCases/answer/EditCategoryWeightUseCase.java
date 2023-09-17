package com.quizplayground.quizplayground.useCases.answer;

import com.quizplayground.quizplayground.exceptions.AnswerNotFoundException;
import com.quizplayground.quizplayground.exceptions.CategoryWeightNotFoundException;
import com.quizplayground.quizplayground.models.Answer;
import com.quizplayground.quizplayground.models.CategoryWeight;
import com.quizplayground.quizplayground.repositories.AnswerRepository;
import com.quizplayground.quizplayground.repositories.CategoryWeightRepository;
import com.quizplayground.quizplayground.requestDtos.answer.PatchCategoryWeightRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditCategoryWeightUseCase {

  @Autowired
  private AnswerRepository answerRepository;
  @Autowired
  private CategoryWeightRepository categoryWeightRepository;

  public Answer handle(Long answerId, PatchCategoryWeightRequestDto requestDto) {
    Answer answer = this.answerRepository
        .findById(answerId)
        .orElseThrow(() -> new AnswerNotFoundException(answerId));

    CategoryWeight categoryWeight = this.categoryWeightRepository
        .findById(requestDto.id)
        .orElseThrow(() -> new CategoryWeightNotFoundException(requestDto.id));

    categoryWeight.setWeight(requestDto.weight);
    this.categoryWeightRepository.save(categoryWeight);
    this.answerRepository.refresh(answer);

    return answer;
  }
}
