package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificacao.INotificador;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

//@Configuration
public class ServiceConfig {
	
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {				
		return new AtivacaoClienteService();
	}

}
