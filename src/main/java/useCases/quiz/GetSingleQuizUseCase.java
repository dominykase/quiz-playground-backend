package useCases.quiz;

import exceptions.QuizNotFoundException;
import models.Quiz;
import repositories.QuizRepository;

public class GetSingleQuizUseCase {
    private final QuizRepository quizRepository;
    public GetSingleQuizUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz handle(Long quizId) {
        return this.quizRepository
                .findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException(quizId));
    }
}
