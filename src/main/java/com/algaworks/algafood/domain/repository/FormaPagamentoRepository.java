package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {
	public FormaPagamento buscar(Long id);
	public List<FormaPagamento> listar();
	public FormaPagamento salvar(FormaPagamento formaPagamento);
	public void remover(FormaPagamento formaPagamento);	
}
