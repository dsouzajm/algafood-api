package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements CustomizedRestauranteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        /*String jpql = " from Restaurante where nome like :nome and taxaFrete between :taxaFreteInicial and :taxaFreteFinal";

        TypedQuery<Restaurante> query = entityManager.createQuery(jpql, Restaurante.class);
        query.setParameter("nome", "%"+nome+"%");
        query.setParameter("taxaFreteInicial", taxaFreteInicial);
        query.setParameter("taxaFreteFinal", taxaFreteFinal);*/

        StringBuilder jpql = new StringBuilder(" from Restaurante where 0 = 0 ");
        HashMap<String, Object> parametros = new HashMap<>();

        if(StringUtils.hasLength(nome)){
            jpql.append("and nome like :nome ");
            parametros.put("nome", "%" + nome + "%");
        }

        if(taxaFreteInicial != null){
            jpql.append("and taxaFrete >= :taxaFreteInicial ");
            parametros.put("taxaFreteInicial", taxaFreteInicial);
        }

        if(taxaFreteFinal != null){
            jpql.append("and taxaFrete <= :taxaFreteFinal ");
            parametros.put("taxaFreteFinal", taxaFreteFinal);
        }

        TypedQuery<Restaurante> query = entityManager.createQuery(jpql.toString(), Restaurante.class);
        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }
}
