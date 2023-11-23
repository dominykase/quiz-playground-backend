package com.quizplayground.quizplayground.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.daos.SubmissionResultDao;
import com.quizplayground.quizplayground.jsonResources.SubmissionResult;

@Service
public class QuizResultsService {
    @Autowired
    private SubmissionResultDao submissionResultDao; 

    public List<SubmissionResult> calculateSubmission(UUID takeUuid) {
        return this.submissionResultDao.getCategoryWeightSum(takeUuid);
    }
}
