package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

    public List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    @Query(" from Restaurante where nome like %:nome and cozinha.id = :idCozinha")
    public List<Restaurante> getRestaurantes(String nome, Long idCozinha);

    public List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

}
