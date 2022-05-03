package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.repository.CozinhaRepository;

public class AdicaoCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Cozinha adicionada 1");

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Cozinha adicionada 2");
		
		Cozinha cozinhaAdicionada = cozinhaRepository.salvar(cozinha1);
		cozinhaRepository.salvar(cozinha2);
				
		cozinhaAdicionada.setNome("Cozinha adicionada 1 (alterada)");
		cozinhaAdicionada = cozinhaRepository.salvar(cozinhaAdicionada);
		
		System.out.println(cozinhaAdicionada.getId() + cozinhaAdicionada.getNome());				
	}

}
