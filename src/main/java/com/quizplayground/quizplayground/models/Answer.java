package com.quizplayground.quizplayground.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answers")
public class Answer {
  private @Getter @Setter @Id @GeneratedValue Long id;

  private @Getter @Setter String text;

  @ManyToOne
  @JoinColumn(name = "question_id")
  @JsonIgnore
  private @Getter @Setter Question question;

  @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
  private @Getter @Setter List<CategoryWeight> categoryWeights;
}
