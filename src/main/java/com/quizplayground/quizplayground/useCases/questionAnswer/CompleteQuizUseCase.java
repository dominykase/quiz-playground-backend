package com.quizplayground.quizplayground.useCases.questionAnswer;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizplayground.quizplayground.jsonResources.SubmissionResult;
import com.quizplayground.quizplayground.models.*;
import com.quizplayground.quizplayground.repositories.QuestionAnswerRepository;
import com.quizplayground.quizplayground.requestDtos.questionAnswer.PostCompleteQuizRequestDto;
import com.quizplayground.quizplayground.requestDtos.questionAnswer.QuestionAnswerDto;
import com.quizplayground.quizplayground.services.QuizResultsService;

@Service
public class CompleteQuizUseCase {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Autowired
    private QuizResultsService quizResultsService;

    public List<SubmissionResult> handle(PostCompleteQuizRequestDto requestDto) {

        UUID uuid = UUID.randomUUID();
        while (!this.questionAnswerRepository.findByTakeUuid(uuid.toString()).isEmpty()) {
            uuid = UUID.randomUUID();
        }

        for (int i = 0; i < requestDto.questionAnswers.size(); ++i) {
            QuestionAnswerDto questionAnswerDto = requestDto.questionAnswers.get(i);

            QuestionAnswer questionAnswer = new QuestionAnswer();
            questionAnswer.setTakeUuid(uuid.toString());
            questionAnswer.setQuiz(requestDto.quizId);
            questionAnswer.setQuestion(questionAnswerDto.questionId);
            questionAnswer.setAnswer(questionAnswerDto.answerId);

            this.questionAnswerRepository.save(questionAnswer);
        }

        return this.quizResultsService.calculateSubmission(uuid);
    }
}
