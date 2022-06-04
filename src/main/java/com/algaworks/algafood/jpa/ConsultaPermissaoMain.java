package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.model.repository.PermissaoRepository;

public class ConsultaPermissaoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		Permissao permissao1 = new Permissao();
		Permissao permissao2 = new Permissao();
		
		permissao1.setNome("Nome 1");
		permissao1.setDescricao("Teste inclusao 1");
		
		permissao2.setNome("Nome 2");
		permissao2.setDescricao("Teste inclusao 2");
		
		permissaoRepository.salvar(permissao1);
		permissaoRepository.salvar(permissao2);
		
		List<Permissao> permissoes = permissaoRepository.listar();
		
		for(Permissao permissao: permissoes) {
			System.out.println("Permissao ID: " + permissao.getId() + ", Permissao Nome: " + permissao.getDescricao());
		}
		
		Permissao permissaoPorID = permissaoRepository.buscar(2L);
		System.out.println("==============PermissaoRepository==============");		
		System.out.println("Permissao ID: " + permissaoPorID.getId() + ", FormaPagamento Nome: " + permissaoPorID.getDescricao());
		
		
		permissao1.setId(1L);
		permissaoRepository.remover(permissao1);
		
		List<Permissao> permissoes1 = permissaoRepository.listar();
		
		System.out.println("==============PermissaoRepository LISTAGEM FINAL==============");
		for(Permissao permissao: permissoes1) {
			System.out.println("Permissao ID: " + permissao.getId() + ", Permissao Nome: " + permissao.getNome() + ", Permissao Descricao: " + permissao.getDescricao());
		}
	}

}
