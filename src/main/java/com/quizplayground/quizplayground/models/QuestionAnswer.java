package com.quizplayground.quizplayground.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question_answers") 
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswer {
    private @Id @GeneratedValue @Getter @Setter Long id;

    @Column(name = "take_uuid", unique = false)
    private @Getter @Setter String takeUuid;

    @Column(name = "quiz_id", unique = false)
    private @Getter @Setter Long quiz;

    @Column(name = "question_id", unique = false)
    private @Getter @Setter Long question;

    @Column(name = "answer_id", unique = false)
    private @Getter @Setter Long answer;
}
