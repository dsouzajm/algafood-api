package com.algaworks.algafood.infrastructure.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoyImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Permissao buscar(Long id) {
		
		return manager.find(Permissao.class, id);
	}

	@Override
	public List<Permissao> listar() {

		return manager.createQuery(" from Permissao", Permissao.class).getResultList();
	}

	@Transactional
	@Override
	public Permissao salvar(Permissao permissao) {

		return manager.merge(permissao);
	}

	@Transactional
	@Override
	public void remover(Permissao permissao) {

		manager.remove(buscar(permissao.getId()));
	}
}
