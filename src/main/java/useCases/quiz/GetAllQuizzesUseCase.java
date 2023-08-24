package useCases.quiz;

import models.Quiz;
import repositories.QuizRepository;

import java.util.List;

public class GetAllQuizzesUseCase {
    private final QuizRepository quizRepository;

    public GetAllQuizzesUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> handle() {
        return this.quizRepository.findAll();
    }
}
