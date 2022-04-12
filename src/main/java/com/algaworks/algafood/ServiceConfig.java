package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;

import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

public class ServiceConfig {

	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService();
	}

}
