package com.quizplayground.quizplayground.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;

@Entity
@Table(name = "categories")
public class Category {
    private @Id @GeneratedValue Long id;

    private @Getter @Setter String name;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private @Getter @Setter Quiz quiz;
}
