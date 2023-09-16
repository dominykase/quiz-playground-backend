package com.quizplayground.quizplayground.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
@NoArgsConstructor
public class Question {
    private @Getter @Setter @Id @GeneratedValue Long id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private @Getter @Setter List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private @Getter @Setter Quiz quiz;

    private @Getter @Setter String text;
}
