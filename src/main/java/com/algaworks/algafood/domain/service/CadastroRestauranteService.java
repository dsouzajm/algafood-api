package com.algaworks.algafood.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> listar(){
		
		List<Restaurante> restaurantes = restauranteRepository.listar();
		
		return restaurantes;
	}

	public Restaurante buscar(Long id) {

		Restaurante restaurante = restauranteRepository.buscar(id);
		
		return restaurante;		
	}

	public Restaurante atualizar(Long id, Restaurante restaurante) {

		Restaurante restauranteTarget = restauranteRepository.buscar(id);
		
		BeanUtils.copyProperties(restaurante, restauranteTarget, "id");
		
		Restaurante restauranteSalvo = restauranteRepository.salvar(restauranteTarget);
		
		return restauranteSalvo;
	}
	
	public Restaurante adicionar(Restaurante restaurante) {

		try {
			
			return restauranteRepository.salvar(restaurante);
		
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException(
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
