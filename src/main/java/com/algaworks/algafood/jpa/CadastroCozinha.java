package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar() {
		  TypedQuery<Cozinha> createQuery = manager.createQuery("from Cozinha", Cozinha.class);
		  
		  return createQuery.getResultList();
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		
		return manager.merge(cozinha);		
	}
	
	public Cozinha buscar(Long id) {
		
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	public void remover(Cozinha cozinha) {
		
		cozinha = manager.find(Cozinha.class, cozinha.getId());
		
		manager.remove(cozinha);
	}
	
}
