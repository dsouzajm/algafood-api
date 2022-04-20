package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class CadastroCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Cozinha adicionada 1");

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Cozinha adicionada 2");
		
		cadastroCozinha.salvar(cozinha1);
		cadastroCozinha.salvar(cozinha2);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for(Cozinha cozinha: cozinhas) {
			System.out.println("Cozinha ID: " + cozinha.getNome() + ", Cozinha Nome: " + cozinha.getNome());
		}
		
		Cozinha cozinhaPorID = cadastroCozinha.buscar(2L);
		System.out.println("Cozinha por ID: " + cozinhaPorID.getNome());
	}

}
