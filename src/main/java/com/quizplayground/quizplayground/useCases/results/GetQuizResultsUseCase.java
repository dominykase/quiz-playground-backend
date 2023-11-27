package com.quizplayground.quizplayground.useCases.results;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.daos.AnswerFrequenciesDao;
import com.quizplayground.quizplayground.daos.CategoryDistributionDao;
import com.quizplayground.quizplayground.exceptions.QuizNotFoundException;
import com.quizplayground.quizplayground.jsonResources.results.FrequenciesQuestion;
import com.quizplayground.quizplayground.jsonResources.results.ResultsOverview;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;

@Service
public class GetQuizResultsUseCase {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerFrequenciesDao answerFrequenciesDao;
    @Autowired
    private CategoryDistributionDao categoryDistributionDao;

    public ResultsOverview handle(Long quizId) {
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
        
        ResultsOverview resultsOverview = new ResultsOverview();
        resultsOverview.categoryDistribution = this.categoryDistributionDao.calculate(quizId);
        resultsOverview.frequencies = this.answerFrequenciesDao.getAnswerFrequencies(quizId);

        return resultsOverview;
    }
}
