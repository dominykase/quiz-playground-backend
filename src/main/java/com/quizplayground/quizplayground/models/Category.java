package com.quizplayground.quizplayground.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;

@Entity
public class Category {
    private @Id @GeneratedValue Long id;
    private String name;
    @ManyToOne
    private Quiz quiz;
}
