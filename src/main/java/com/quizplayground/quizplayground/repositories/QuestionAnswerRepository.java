package com.quizplayground.quizplayground.repositories;

import java.util.List;

import com.quizplayground.quizplayground.models.QuestionAnswer;

public interface QuestionAnswerRepository extends CustomRepository<QuestionAnswer, Long>{
    List<QuestionAnswer> findByTakeUuid(String uuid);
}
