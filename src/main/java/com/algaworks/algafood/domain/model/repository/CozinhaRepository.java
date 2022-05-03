package com.algaworks.algafood.domain.model.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	public Cozinha salvar(Cozinha cozinha);
	public List<Cozinha> listar();
	public void remover(Cozinha cozinha);
	public Cozinha buscar(Long id);
	
}
