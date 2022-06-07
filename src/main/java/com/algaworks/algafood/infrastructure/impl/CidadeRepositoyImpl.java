package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoyImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Cidade buscar(Long id) {
		
		return manager.find(Cidade.class, id);
	}

	@Override
	public List<Cidade> listar() {

		return manager.createQuery(" from Cidade", Cidade.class).getResultList();
	}

	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {

		return manager.merge(cidade);
	}

	@Transactional
	@Override
	public void remover(Cidade cidade) {

		manager.remove(buscar(cidade.getId()));
	}
}
