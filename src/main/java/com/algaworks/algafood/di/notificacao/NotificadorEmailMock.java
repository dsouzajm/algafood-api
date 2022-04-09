package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//@Qualifier("normal")
@Component
public class NotificadorEmailMock implements INotificador{
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
				
		System.out.printf("Seria enviado uma notificacao %s através do e-mail %s: %s\n"
				, cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
