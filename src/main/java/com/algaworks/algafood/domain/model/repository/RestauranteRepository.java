package com.algaworks.algafood.domain.model.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	public Restaurante buscar(Long id);
	public List<Restaurante> listar();
	public Restaurante salvar(Restaurante restaurante);	
	public void remover(Restaurante cozinha);		
}
