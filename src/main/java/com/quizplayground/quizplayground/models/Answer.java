package com.quizplayground.quizplayground.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers")
public class Answer {
    private @Id @GeneratedValue Long id;

    private @Getter @Setter String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private @Getter @Setter Question question;
}
