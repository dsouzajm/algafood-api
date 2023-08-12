package com.algaworks.algafood.infrastructure.impl;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> {

    private EntityManager entityManager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    public Optional<T> buscarPrimeiro() {

        String jpql = " from " + getDomainClass().getName();

        TypedQuery<T> query = entityManager.createQuery(jpql, getDomainClass()).setMaxResults(1);
        return Optional.of(query.getSingleResult());
    }
}
