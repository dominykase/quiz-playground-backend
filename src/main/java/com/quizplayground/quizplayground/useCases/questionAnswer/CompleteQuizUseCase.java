package com.quizplayground.quizplayground.useCases.questionAnswer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.models.*;
import com.quizplayground.quizplayground.repositories.QuestionAnswerRepository;
import com.quizplayground.quizplayground.requestDtos.questionAnswer.PostCompleteQuizRequestDto;
import com.quizplayground.quizplayground.requestDtos.questionAnswer.QuestionAnswerDto;

@Service
public class CompleteQuizUseCase {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public void handle(PostCompleteQuizRequestDto requestDto) {

        UUID uuid = UUID.randomUUID();
        while (!this.questionAnswerRepository.findByTakeUuid(uuid.toString()).isEmpty()) {
            uuid = UUID.randomUUID();
        }

        for (int i = 0; i < requestDto.questionAnswers.size(); ++i) {
            QuestionAnswerDto questionAnswerDto = requestDto.questionAnswers.get(i);

            QuestionAnswer questionAnswer = new QuestionAnswer();
            questionAnswer.setTakeUuid(uuid.toString());
            questionAnswer.setQuizId(requestDto.quizId);
            questionAnswer.setQuestionId(questionAnswerDto.questionId);
            questionAnswer.setAnswerId(questionAnswerDto.answerId);

            this.questionAnswerRepository.save(questionAnswer);
        }
    }
}
