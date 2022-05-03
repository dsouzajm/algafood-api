package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements INotificador{
	
	@Autowired
	private NotificaoProperties notificacaoProperties;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {				
		
		System.out.println("Nome do servidor de email: " + notificacaoProperties.getHostServidor());
		
		System.out.println("Porta do servidor de email: " + notificacaoProperties.getPortaServidor());
		
		System.out.printf("Seria enviado uma notificacao %s através do e-mail %s: %s\n"
							, cliente.getNome()
							, cliente.getEmail()
							, mensagem);
	}

}
