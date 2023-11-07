package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
	public Permissao buscar(Long id);
	public List<Permissao> listar();
	public Permissao salvar(Permissao permissao);
	public void remover(Permissao permissao);
}
