package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		/*Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Restaurante adicionado 1");
		restaurante1.setTaxaFrete(new BigDecimal(8));

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Restaurante adicionado 2");
		restaurante2.setTaxaFrete(new BigDecimal(5));
		
		restauranteRepository.salvar(restaurante1);
		restauranteRepository.salvar(restaurante2);*/
		
		List<Restaurante> restaurantes = restauranteRepository.listar();
		
		System.out.println("==============Query==============");
		for(Restaurante restaurante: restaurantes) {
			System.out.println("Restaurante ID: " + restaurante.getId() + 
				", Restaurante Nome: " + restaurante.getNome() +
				", Restaurante Taxa Frete: " + restaurante.getTaxaFrete() + 
				", Restaurante Cozinha ID: " + restaurante.getCozinha().getNome()
			);
		}
		
		Restaurante restaurantePorID = restauranteRepository.buscar(2L);
		System.out.println("==============RestauranteRepository==============");
		System.out.println("Restaurante ID: " + restaurantePorID.getId() + 
			", Restaurante Nome: " + restaurantePorID.getNome() +
			", Restaurante Taxa Frete: " + restaurantePorID.getTaxaFrete() +
			", Restaurante Cozinha ID: " + restaurantePorID.getCozinha().getNome()
		);
	}

}
