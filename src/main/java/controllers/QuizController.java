package controllers;

import jakarta.validation.Valid;
import models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import requestDtos.quiz.PatchQuizRequestDto;
import requestDtos.quiz.PostQuizRequestDto;
import useCases.quiz.CreateQuizUseCase;
import useCases.quiz.GetAllQuizzesUseCase;
import useCases.quiz.GetSingleQuizUseCase;
import useCases.quiz.UpdateQuizUseCase;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    private GetSingleQuizUseCase getSingleQuizUseCase;
    @Autowired
    private GetAllQuizzesUseCase getAllQuizzesUseCase;
    @Autowired
    private CreateQuizUseCase createQuizUseCase;
    @Autowired
    private UpdateQuizUseCase updateQuizUseCase;

    @GetMapping("/quiz")
    public List<Quiz> getAll() {
        return this.getAllQuizzesUseCase.handle();
    }

    @GetMapping("/quiz/{quizId}")
    public Quiz getById(@PathVariable Long quizId) {
        return this.getSingleQuizUseCase.handle(quizId);
    }

    @PostMapping("/quiz")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public Quiz create(@RequestBody @Valid PostQuizRequestDto requestDto) {
        return this.createQuizUseCase.handle(requestDto);
    }

    @PatchMapping("/quiz")
    public Quiz update(@RequestBody @Valid PatchQuizRequestDto requestDto) {
        return this.updateQuizUseCase.handle(requestDto);
    }
}
