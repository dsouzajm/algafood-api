package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento1 = new FormaPagamento();
		FormaPagamento formaPagamento2 = new FormaPagamento();
		
		formaPagamento1.setDescricao("Teste inclusao 1");
		formaPagamento2.setDescricao("Teste inclusao 2");
		
		formaPagamentoRepository.salvar(formaPagamento1);
		formaPagamentoRepository.salvar(formaPagamento2);
		
		List<FormaPagamento> formasPagamento = formaPagamentoRepository.listar();
		
		for(FormaPagamento formaPagamento: formasPagamento) {
			System.out.println("FormaPagamento ID: " + formaPagamento.getId() + ", FormaPagamento Nome: " + formaPagamento.getDescricao());
		}
		
		FormaPagamento formaPagamentoPorID = formaPagamentoRepository.buscar(2L);
		System.out.println("==============FormaPagamentoRepository==============");		
		System.out.println("FormaPagamento ID: " + formaPagamentoPorID.getId() + ", FormaPagamento Nome: " + formaPagamentoPorID.getDescricao());
		
		
		formaPagamento1.setId(1L);
		formaPagamentoRepository.remover(formaPagamento1);
		
		List<FormaPagamento> formasPagamento1 = formaPagamentoRepository.listar();
		
		System.out.println("==============FormaPagamentoRepository LISTAGEM FINAL==============");
		for(FormaPagamento formaPagamento: formasPagamento1) {
			System.out.println("FormaPagamento ID: " + formaPagamento.getId() + ", FormaPagamento Nome: " + formaPagamento.getDescricao());
		}
	}

}
