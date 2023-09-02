package com.quizplayground.quizplayground.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    private @Id @GeneratedValue Long id;
    @OneToMany
    private List<Answer> answerList;
    @ManyToOne
    private Quiz quiz;
    private String text;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answerList;
    }

    public void setAnswers(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
