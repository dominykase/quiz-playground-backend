package com.quizplayground.quizplayground.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity
public class Category {
    private @Id @GeneratedValue Long id;
    @Getter
    @Setter
    private String name;
    @ManyToOne
    @Getter
    @Setter
    private Quiz quiz;
}
