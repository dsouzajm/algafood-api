package com.algaworks.algafood.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		List<Restaurante> restaurantes = restauranteRepository.listar();
		
		return restaurantes;
	}

	public Restaurante buscar(Long id) {
		
		Restaurante restaurante = restauranteRepository.buscar(id);

		if(restaurante != null)
			return restaurante;
		
		throw new EntidadeNaoEncontradaException(
			String.format("Não existe restaurante com o código %d", id)
		);
				
	}

	public Restaurante atualizar(Long id, Restaurante restaurante) {

		Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
		
		if(cozinha != null) {
		
			Restaurante restauranteTarget = restauranteRepository.buscar(id);
			
			if(restauranteTarget != null) {
												
				BeanUtils.copyProperties(restaurante, restauranteTarget, "id");
				restauranteTarget.setCozinha(cozinha);
				Restaurante restauranteSalvo = restauranteRepository.salvar(restauranteTarget);
				return restauranteSalvo;
			} else {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe restaurante com o código %d.", id)
					);				
			}
			
		} else {
			
			throw new PropriedadeNaoEncontradaException(
					String.format("Não existe cozinha com o código %d.", restaurante.getCozinha().getId())
				);
		}		
	}
	
	public Restaurante adicionar(Restaurante restaurante) {

		try {
			
			return restauranteRepository.salvar(restaurante);
		} catch (EntityNotFoundException e) {
			
			throw new PropriedadeNaoEncontradaException(
				String.format("Não existe um cadastro de cozinha com código %d", restaurante.getCozinha().getId())			
			);			
		}
	}
	
	public void excluir(Long id) {
		
		try {
		
			restauranteRepository.remover(buscar(id));
		} catch (EntityNotFoundException | NullPointerException e) {
			
			throw new EntidadeNaoEncontradaException(
				String.format("Entidade restaraunte não encontrada! %d", id)
			);
		}
	}
	
}
