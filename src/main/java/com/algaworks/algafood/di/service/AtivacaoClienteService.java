package com.algaworks.algafood.di.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class AtivacaoClienteService {

	// @TipoDoNotificador(NivelUrgencia.URGENTE)
	// @Qualifier("urgente")
	// @Autowired
	// private INotificador notificador;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

//	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//	@Autowired
//	public AtivacaoClienteService() {	
//		this.notificador = notificador;
//		
//		System.out.println("AtivacaoClienteService: " + notificador);
//	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

		// notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
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