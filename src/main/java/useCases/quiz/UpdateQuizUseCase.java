package useCases.quiz;

import models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.QuizRepository;
import requestDtos.quiz.PatchQuizRequestDto;
import requestDtos.quiz.PostQuizRequestDto;

public class UpdateQuizUseCase {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz handle(PatchQuizRequestDto requestDto) {
        return quizRepository.save(requestDto.toQuiz());
    }
}
