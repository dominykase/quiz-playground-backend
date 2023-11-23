package com.quizplayground.quizplayground.daos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quizplayground.quizplayground.jsonResources.SubmissionResult;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class SubmissionResultDao {
    @Autowired
    private EntityManager entityManager;

    public List<SubmissionResult> getCategoryWeightSum(UUID takeUuid) {
        String queryString = "SELECT c.name, SUM(cw.weight) FROM QuestionAnswer qa "
                + "JOIN CategoryWeight cw ON qa.answer = cw.answer.id  "
                + "JOIN Category c ON cw.category.id = c.id "
                + "WHERE qa.takeUuid = :takeUuid "
                + "GROUP BY c.name";

        TypedQuery<Object[]> query = this.entityManager.createQuery(queryString, Object[].class);
        query.setParameter("takeUuid", takeUuid.toString());

        return this.mapToEntity(query.getResultList());
    }

    private List<SubmissionResult> mapToEntity(List<Object[]> resultList) {
        List<SubmissionResult> submissionResults = new java.util.ArrayList<SubmissionResult>(); 

        for (Object[] result: resultList) {
            String categoryName = (String) result[0];
            int weightSum = ((Long) result[1]).intValue();

            SubmissionResult submissionResult = new SubmissionResult(categoryName, weightSum);
            submissionResults.add(submissionResult);
        }

        return submissionResults;
    }
}
