package com.algaworks.algafood.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar(){
		
		return estadoRepository.findAll();
	}

	public Estado buscar(Long id) {
		
		Estado estado = estadoRepository.findById(id)
										.orElseThrow(() -> new EntidadeNaoEncontradaException("Estado de id " + id + " não encontrado."));
		
		return estado;
	}
	
	public Estado salvar(Estado estado) {
		
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long id) {

		try {			
			estadoRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {

			throw new EntidadeEmUsoException(
				String.format("Estado de código %d não pode ser removido, pois está em uso.", id)				
			);
			
		} catch (IllegalArgumentException | EmptyResultDataAccessException e) {

			throw new EntidadeNaoEncontradaException(
				String.format("Não existe estado com o código %d.", id)			
			);
		} 
	}
}
