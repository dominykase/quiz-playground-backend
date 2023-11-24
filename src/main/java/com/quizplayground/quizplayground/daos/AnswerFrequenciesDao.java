package com.quizplayground.quizplayground.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quizplayground.quizplayground.jsonResources.results.FrequenciesAnswer;
import com.quizplayground.quizplayground.jsonResources.results.FrequenciesQuestion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AnswerFrequenciesDao {
    @Autowired
    private EntityManager entityManager;

    public List<FrequenciesQuestion> getAnswerFrequencies(Long quizId) {
        String queryString = "SELECT q.id, q.text, a.id, a.text, COUNT(qa.answer) "
            + "FROM Question q "
            + "JOIN Answer a ON q.id = a.question.id "
            + "LEFT JOIN QuestionAnswer qa ON a.id = qa.answer " 
            + "WHERE q.quiz.id = :quizId "
            + "GROUP BY q.id, q.text, a.id, a.text";

        TypedQuery<Object[]> query = this.entityManager.createQuery(queryString, Object[].class);
        query.setParameter("quizId", quizId.toString());

        return this.mapToEntity(query.getResultList());
    }

    private List<FrequenciesQuestion> mapToEntity(List<Object[]> results) {
        List<FrequenciesQuestion> frequenciesQuestions = new ArrayList<FrequenciesQuestion>();
        Map<Long, Boolean> filledQuestionMap = new HashMap<Long, Boolean>();

        for (Object[] result : results) {
            FrequenciesQuestion frequenciesQuestion = new FrequenciesQuestion();
            frequenciesQuestion.setId((Long) result[0]);
            frequenciesQuestion.setQuestionText((String) result[1]);
            frequenciesQuestion.answers = new ArrayList<FrequenciesAnswer>();
            
            if (!filledQuestionMap.containsKey(frequenciesQuestion.getId())) {
                filledQuestionMap.put(frequenciesQuestion.getId(), true);
                frequenciesQuestions.add(frequenciesQuestion);
            }
        }

        for (Object[] result: results) {
            FrequenciesQuestion frequenciesQuestion = new FrequenciesQuestion();

            for (FrequenciesQuestion fq : frequenciesQuestions) {
                if (Objects.equals(fq.getId(), (Long) result[0])) {
                    frequenciesQuestion = fq;
                    break;
                }
            }

            FrequenciesAnswer frequenciesAnswer = new FrequenciesAnswer();
            frequenciesAnswer.setId((Long) result[2]);
            frequenciesAnswer.setAnswerText((String) result[3]);
            frequenciesAnswer.setCount((Long) result[4]);

            frequenciesQuestion.answers.add(frequenciesAnswer);
        }

        return frequenciesQuestions;
    }
}
