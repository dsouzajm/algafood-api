package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;	

	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}	

	@Override
	public List<Cozinha> listar() {		
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}	
	
	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {		
		return manager.merge(cozinha);
	}

	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		manager.remove(manager.find(Cozinha.class, cozinha.getId()));		
	}
}
