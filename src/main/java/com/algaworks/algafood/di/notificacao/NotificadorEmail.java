package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//@Qualifier("normal")
@Component
public class NotificadorEmail implements INotificador {	
	
	@Autowired
	private NotificaoProperties notificacaoProperties;
	
	//@Value("${notificador.email.host-servidor}")
	
	private String nomeServidor;
	
	//@Value("${notificador.email.porta-servidor}")
	private Integer portaServidor;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
	

		System.out.println("Nome do servidor de email: " + nomeServidor);
		System.out.println("Porta do servidor de email: " + portaServidor);
		
		System.out.printf("Notificando cliente %s através do e-mail %s: %s\n"
						 , cliente.getNome()
						 , cliente.getEmail()
						 , mensagem);
	}

}
