package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	//public List<Cozinha> listarPorNome(String nome);
}
