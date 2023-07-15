package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class RestauranteRepositoryImpl implements CustomizedRestauranteRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        String jpql = " from Restaurante where nome like :nome and taxaFrete between :taxaFreteInicial and :taxaFreteFinal";
        TypedQuery<Restaurante> query = entityManager.createQuery(jpql, Restaurante.class);
        query.setParameter("nome", "%"+nome+"%");
        query.setParameter("taxaFreteInicial", taxaFreteInicial);
        query.setParameter("taxaFreteFinal", taxaFreteFinal);

        return query.getResultList();
    }
}
