package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//@Qualifier("normal")
@Component
public class NotificadorEmail implements INotificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.printf("Notificando1 cliente %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(),
				mensagem);
	}

}
