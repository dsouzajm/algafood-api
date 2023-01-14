package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	public Cozinha buscar(Long id);
	public List<Cozinha> listar();
	public List<Cozinha> listarPorNome(String nome);

	public Cozinha salvar(Cozinha cozinha);
	public void remover(Long id);	
}
