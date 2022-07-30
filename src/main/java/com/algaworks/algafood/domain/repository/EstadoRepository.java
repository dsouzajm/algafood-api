package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	public Estado buscar(Long id);
	public List<Estado> listar();
	public Estado salvar(Estado estado);
	public void remover(Long id);
}
