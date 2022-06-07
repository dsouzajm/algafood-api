package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	
	public FormaPagamento buscar(Long id);
	public List<FormaPagamento> listar();
	public FormaPagamento salvar(FormaPagamento formaPagamento);
	public void remover(FormaPagamento formaPagamento);	
}
