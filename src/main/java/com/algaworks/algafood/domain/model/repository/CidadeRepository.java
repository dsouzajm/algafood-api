package com.algaworks.algafood.domain.model.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

	public Cidade buscar(Long id);
	public List<Cidade> listar();
	public Cidade salvar(Cidade estado);
	public void remover(Cidade estado);
}
