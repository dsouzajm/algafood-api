package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    public List<Cozinha> findTodasByNome(String nome);

    public Optional<Cozinha> findUnicaByNome(String nome);
}
