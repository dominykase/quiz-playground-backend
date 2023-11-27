package com.quizplayground.quizplayground.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CategoryDistributionDao {
    @Autowired
    private EntityManager entityManager;

    public Map<Long, Long> calculate(Long quizId) {
        Map<Long, Long> categoryDistribution = new HashMap<Long, Long>();
        List<String> takeUuids = this.getQuizTakeUuids(quizId);

        for (String takeUuid: takeUuids) {
            List<Object[]> takeResults = this.getTakeResults(takeUuid);
            
            Long maxId = 0L;
            Long max = 0L;

            for (Object[] takeResult: takeResults) {
                if (Long.compare((Long) takeResult[2], max) > 0) {
                    maxId = (Long) takeResult[0];
                    max = (Long) takeResult[2];
                }
            }

            if (categoryDistribution.containsKey(maxId)) {
                categoryDistribution.put(maxId, categoryDistribution.get(maxId) + 1L);
            } else {
                categoryDistribution.put(maxId, 1L);
            }
        }

        return categoryDistribution;
    }

    private List<Object[]> getTakeResults(String takeUuid) {
        String jpql = "SELECT c.id, c.name, SUM(cw.weight) "
            + "FROM QuestionAnswer qa "
            + "JOIN CategoryWeight cw ON qa.answer = cw.answer.id "
            + "JOIN Category c ON cw.category.id = c.id "
            + "WHERE qa.takeUuid = :takeUuid "
            + "GROUP BY c.id, c.name";
        
        TypedQuery<Object[]> query = this.entityManager.createQuery(jpql, Object[].class);
        query.setParameter("takeUuid", takeUuid);

        return query.getResultList();
    }

    private List<String> getQuizTakeUuids(Long quizId) {
        String jpql = "SELECT DISTINCT qa.takeUuid "
            + "FROM QuestionAnswer qa "
            + "WHERE qa.quiz = :quizId";

        TypedQuery<String> query = this.entityManager.createQuery(jpql, String.class);
        query.setParameter("quizId", quizId);
        return query.getResultList();
    }
}
