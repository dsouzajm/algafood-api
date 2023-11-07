package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AtivacaoClienteService {
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	public void ativar(Cliente cliente) {
		cliente.ativar();
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy()");
	}
}