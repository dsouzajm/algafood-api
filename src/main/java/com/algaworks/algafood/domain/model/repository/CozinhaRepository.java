package com.algaworks.algafood.domain.model.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	public Cozinha buscar(Long id);
	public List<Cozinha> listar();	
	public Cozinha salvar(Cozinha cozinha);
	public void remover(Cozinha cozinha);	
}
