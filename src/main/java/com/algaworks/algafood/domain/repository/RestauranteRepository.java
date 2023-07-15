package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, CustomizedRestauranteRepository {

    public List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    //@Query(" from Restaurante where nome like %:nome and cozinha.id = :idCozinha")
    public List<Restaurante> getRestaurantes(String nome, @Param("idCozinha") Long cozinhaId);

    public List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

    //public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
