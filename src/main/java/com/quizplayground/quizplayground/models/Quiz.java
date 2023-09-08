package com.quizplayground.quizplayground.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
public class Quiz {
    private @Getter @Setter @Id @GeneratedValue Long id;

    private @Getter @Setter String name;

    private @Getter @Setter String description;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private @Getter @Setter List<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private @Getter @Setter List<Category> categories;
}
