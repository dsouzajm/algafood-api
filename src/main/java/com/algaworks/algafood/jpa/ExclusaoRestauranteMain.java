package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ExclusaoRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository RestauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Restaurante adicionado 1");
		restaurante1.setTaxaFrete(new BigDecimal(8));

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Restaurante adicionado 2");
		restaurante2.setTaxaFrete(new BigDecimal(5));
		
		RestauranteRepository.salvar(restaurante1);
		RestauranteRepository.salvar(restaurante2);
		
		List<Restaurante> Restaurantes = RestauranteRepository.listar();
		
		System.out.println("===================Antes da exclusao===================");
		for(Restaurante Restaurante: Restaurantes) {
			System.out.println("Restaurante ID: " + Restaurante.getNome() + ", Restaurante Nome: " + Restaurante.getNome());
		}		
					
		RestauranteRepository.remover(RestauranteRepository.buscar(1L));
		
		Restaurantes = RestauranteRepository.listar();
		
		System.out.println("===================Apos a exclusao===================");
		for(Restaurante Restaurante: Restaurantes) {
			System.out.println("Restaurante ID: " + Restaurante.getNome() + ", Restaurante Nome: " + Restaurante.getNome());
		}
	}

}
