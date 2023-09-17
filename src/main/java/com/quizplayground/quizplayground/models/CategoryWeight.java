package com.quizplayground.quizplayground.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category_weights")
public class CategoryWeight {

  private @Getter @Setter @Id @GeneratedValue Long id;

  private @Getter @Setter Integer weight;

  @ManyToOne
  @JoinColumn(name = "answer_id")
  @JsonIgnore
  private @Getter @Setter Answer answer;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private @Getter @Setter Category category;
}
