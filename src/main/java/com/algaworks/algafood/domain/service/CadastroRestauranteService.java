package com.algaworks.algafood.domain.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;	
	
	public List<Restaurante> listar(){
		
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		
		return restaurantes;
	}

	public Restaurante buscar(Long id) {

		return restauranteRepository.findById(id)
									.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe restaurante com o código %d", id)));
	}

	public Restaurante atualizar(Long id, Restaurante restaurante) {

		Long cozinhaId = restaurante.getCozinha().getId();

		Cozinha cozinhaTarget = cozinhaRepository.findById(cozinhaId)
												 .orElseThrow(() -> new PropriedadeNaoEncontradaException(String.format("Não existe cozinha com o código %d.", cozinhaId)));

		Restaurante restauranteTarget = restauranteRepository.findById(id)
															 .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe restaurante com o código %d.", id)));

		BeanUtils.copyProperties(restaurante, restauranteTarget, "id");
		restauranteTarget.setCozinha(cozinhaTarget);

		return  restauranteRepository.save(restauranteTarget);
	}
	
	public Restaurante salvar(Restaurante restaurante) {

		Long cozinhaId = restaurante.getCozinha().getId();

		Cozinha cozinhaTarget = cozinhaRepository.findById(cozinhaId)
												 .orElseThrow(() -> new PropriedadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId)));

		restaurante.setCozinha(cozinhaTarget);

		return restauranteRepository.save(restaurante);
	}
	
	public void excluir(Long id) {
		
		try {
		
			restauranteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException | NullPointerException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Entidade restaurante não encontrada %d.", id));
		}
	}
	
}
