package com.quizplayground.quizplayground.useCases.results;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.daos.AnswerFrequenciesDao;
import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.jsonResources.results.FrequenciesQuestion;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;

@Service
public class GetQuizResultsUseCase {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerFrequenciesDao answerFrequenciesDao;

    public List<FrequenciesQuestion> handle(Long quizId) {
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));

        return this.answerFrequenciesDao.getAnswerFrequencies(quizId);
    }
}
