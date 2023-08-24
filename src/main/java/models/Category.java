package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
    private @Id @GeneratedValue Long id;
    private String name;
    @ManyToOne
    private Quiz quiz;
}
