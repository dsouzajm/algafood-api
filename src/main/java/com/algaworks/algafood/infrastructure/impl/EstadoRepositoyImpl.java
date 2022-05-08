package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.repository.EstadoRepository;

@Component
public class EstadoRepositoyImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Estado buscar(Long id) {
		
		return manager.find(Estado.class, id);
	}

	@Override
	public List<Estado> listar() {

		return manager.createQuery(" from Estado", Estado.class).getResultList();
	}

	@Transactional
	@Override
	public Estado salvar(Estado estado) {

		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Estado estado) {

		manager.remove(buscar(estado.getId()));
	}
}
