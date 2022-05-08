package com.algaworks.algafood.domain.model.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	public Permissao buscar(Long id);
	public List<Permissao> listar();
	public Permissao salvar(Permissao permissao);
	public void remover(Permissao permissao);
}
