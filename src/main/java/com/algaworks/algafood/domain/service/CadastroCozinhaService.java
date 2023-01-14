package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

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

		return cozinhaRepository.findAll();
	}

	public Cozinha buscar(Long id) {

		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

		if(cozinha.isPresent())
			return cozinha.get();

		return null;
	}

	public Cozinha salvar(Cozinha cozinha) {

		return cozinhaRepository.save(cozinha);
	}

	public Cozinha atualizar(Long id, Cozinha cozinha) {

		Cozinha cozinhaTarget = cozinhaRepository.findById(id)
												 .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cozinha com o código %d.", id)));

		BeanUtils.copyProperties(cozinha, cozinhaTarget, "id");
		return cozinhaRepository.save(cozinhaTarget);
	}

	public void excluir(Long id) {

		try {
			
			cozinhaRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {

			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso.", id));
			
		} catch (EmptyResultDataAccessException e) {

			throw new EntidadeNaoEncontradaException(String.format("Não existe cozinha com o código %d.", id));
		} 
	}
}
