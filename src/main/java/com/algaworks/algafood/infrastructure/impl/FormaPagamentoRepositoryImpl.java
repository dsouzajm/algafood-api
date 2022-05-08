package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public FormaPagamento buscar(Long id) {

		return manager.find(FormaPagamento.class, id);
	}

	@Override
	public List<FormaPagamento> listar() {

		return manager.createQuery(" from FormaPagamento", FormaPagamento.class).getResultList();
	}

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {

		return manager.merge(formaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {

		manager.remove(buscar(formaPagamento.getId()));
	}	
}
