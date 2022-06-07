package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	public CozinhaRepository cozinhaRepository;

	public List<Cozinha> listar() {

		return cozinhaRepository.listar();
	}

	public Cozinha buscar(Long id) {

		Cozinha cozinha = cozinhaRepository.buscar(id);

		if (cozinha != null) {
			return cozinha;
		}

		return null;
	}

	public Cozinha salvar(Cozinha cozinha) {

		Cozinha cozinhaSalva = cozinhaRepository.salvar(cozinha);

		return cozinhaSalva;
	}

	public Cozinha atualizar(Long id, Cozinha cozinha) {

		Cozinha cozinhaAtual = cozinhaRepository.buscar(id);

		if (cozinhaAtual != null) {

			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);

			return cozinhaAtual;
		}

		return null;
	}

	public void excluir(Long id) {

		try {
			
			cozinhaRepository.remover(id);
		} catch (DataIntegrityViolationException e) {

			throw new EntidadeEmUsoException(
				String.format("Cozinha de código %d não pode ser removida, pois está em uso", id)				
			);
			
		} catch (EmptyResultDataAccessException e) {

			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cozinha com código %d", id)			
			);
		} 
	}
}
