package com.quizplayground.quizplayground.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Answer {
    private @Id @GeneratedValue Long id;
    private String text;
    @ManyToOne
    private Question question;
    private List<Integer> pointsAcrossCategories;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getPointsAcrossCategories() {
        return pointsAcrossCategories;
    }

    public void setPointsAcrossCategories(List<Integer> pointsAcrossCategories) {
        this.pointsAcrossCategories = pointsAcrossCategories;
    }
}
