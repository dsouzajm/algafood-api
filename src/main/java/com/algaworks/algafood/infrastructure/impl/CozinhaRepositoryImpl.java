package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;	

	@Override
	public Cozinha buscar(Long id) {

		return manager.find(Cozinha.class, id);
	}	

	@Override
	public List<Cozinha> listar() {		

		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

	@Override
	public List<Cozinha> listarPorNome(String nome) {

		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {		
		return manager.merge(cozinha);
	}

	@Transactional
	@Override
	public void remover(Long id) {

		Cozinha cozinha = this.buscar(id);
		
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);			
		}
		
		manager.remove(cozinha);		
	}
}
