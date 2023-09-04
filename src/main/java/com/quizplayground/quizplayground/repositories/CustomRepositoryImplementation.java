package com.quizplayground.quizplayground.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

public class CustomRepositoryImplementation<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements CustomRepository<T, ID> {

  private final EntityManager entityManager;

  public CustomRepositoryImplementation(
      JpaEntityInformation<T, ID> entityInformation,
      EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void refresh(T t) {
    entityManager.refresh(t);
  }
}
