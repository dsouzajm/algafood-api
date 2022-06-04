package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.repository.CidadeRepository;

public class ConsultaCidadeMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		Cidade cidade1 = new Cidade();
		
		Estado estado1 = new Estado();
		estado1.setId(1L);
		
		/*Estado estado2 = new Estado();
		estado1.setId(2L);	*/	
		
		cidade1.setNome("São Paulo");
		cidade1.setEstado(estado1);
		
		/*cidade2.setNome("Rio de Janeiro");
		cidade2.setEstado(estado2);	*/	

		cidadeRepository.salvar(cidade1);
		//cidadeRepository.salvar(cidade2);
		
		List<Cidade> cidades = cidadeRepository.listar();
		
		for(Cidade cidade: cidades) {
			System.out.println("Cidade ID: " + cidade.getId() + ", Cidade Nome: " + cidade.getNome() + ", Estado Nome: " + cidade.getEstado().getNome());
		}
		
		Cidade cidadePorID = cidadeRepository.buscar(2L);
		System.out.println("==============CidadeRepository==============");		
		System.out.println("Cidade ID: " + cidadePorID.getId() + ", Cidade Nome: " + cidadePorID.getNome() + ", Estado Nome: " + cidadePorID.getEstado().getNome());
		
		
		cidade1.setId(1L);
		cidadeRepository.remover(cidade1);
		
		List<Cidade> cidades1 = cidadeRepository.listar();
		
		System.out.println("==============CidadeRepository LISTAGEM FINAL==============");
		for(Cidade cidade: cidades1) {
			System.out.println("Cidade ID: " + cidade.getId() + ", Cidade Nome: " + cidade.getNome() + ", Estado Nome: " + cidade.getEstado().getNome());
		}
	}

}
