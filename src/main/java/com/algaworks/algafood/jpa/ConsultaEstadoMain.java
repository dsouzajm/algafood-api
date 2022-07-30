package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class ConsultaEstadoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado1 = new Estado();
		Estado estado2 = new Estado();
		
		estado1.setNome("Nome 1");
		estado2.setNome("Nome 2");

		estadoRepository.salvar(estado1);
		estadoRepository.salvar(estado2);
		
		List<Estado> estados = estadoRepository.listar();
		
		for(Estado estado: estados) {
			System.out.println("Estado ID: " + estado.getId() + ", Estado Nome: " + estado.getNome());
		}
		
		Estado estadoPorID = estadoRepository.buscar(2L);
		System.out.println("==============EstadoRepository==============");		
		System.out.println("Estado ID: " + estadoPorID.getId() + ", Estado Nome: " + estadoPorID.getNome());
		
		
		estado1.setId(1L);
		estadoRepository.remover(estado1.getId());
		
		List<Estado> estados1 = estadoRepository.listar();
		
		System.out.println("==============EstadoRepository LISTAGEM FINAL==============");
		for(Estado estado: estados1) {
			System.out.println("Estado ID: " + estado.getId() + ", Estado Nome: " + estado.getNome());
		}
	}

}
