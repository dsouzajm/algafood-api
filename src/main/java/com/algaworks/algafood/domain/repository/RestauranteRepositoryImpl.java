package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements CustomizedRestauranteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> criteriaQuery = criteriaBuilder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteriaQuery.from(Restaurante.class);

        Predicate likeNome = criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        Predicate taxaFreteMaiorQue = criteriaBuilder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
        Predicate taxaFreteMenorQue = criteriaBuilder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);

        criteriaQuery.where(likeNome, taxaFreteMaiorQue, taxaFreteMenorQue);

        TypedQuery<Restaurante> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
