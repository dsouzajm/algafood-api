package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, CustomizedRestauranteRepository, JpaSpecificationExecutor<Restaurante> {
    @Query("from Restaurante r join fetch r.cozinha join fetch r.formaPagamento")
    public List<Restaurante> findAll();
    public List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
    public List<Restaurante> getRestaurantes(String nome, @Param("idCozinha") Long cozinhaId);
    public List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
}
