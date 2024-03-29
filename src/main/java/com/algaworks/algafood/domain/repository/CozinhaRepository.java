package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    @Query(" from Cozinha where nome like %:nome%")
    public List<Cozinha> getCozinhaPorNome(String nome);
    public List<Cozinha> findTodasByNomeContaining(String nome);
    public Optional<Cozinha> findUnicaByNome(String nome);
}
