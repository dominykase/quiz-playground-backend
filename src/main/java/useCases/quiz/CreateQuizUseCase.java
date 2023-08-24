package useCases.quiz;

import models.Quiz;
import repositories.QuizRepository;
import requestDtos.quiz.PostQuizRequestDto;

public class CreateQuizUseCase {
    private final QuizRepository quizRepository;

    public CreateQuizUseCase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz handle(PostQuizRequestDto requestDto) {
        Quiz newQuiz = new Quiz();
        newQuiz.setName(requestDto.name);
        newQuiz.setDescription(requestDto.description);

        return this.quizRepository.save(newQuiz);
    }
}
