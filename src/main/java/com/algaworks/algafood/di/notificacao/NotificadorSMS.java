package com.algaworks.algafood.di.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
//@Qualifier("urgente")
@Component
public class NotificadorSMS implements INotificador{
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
				
		System.out.printf("Notificando cliente %s por meio de SMS %s: %s\n"
				, cliente.getNome(), cliente.getTelefone(), mensagem);
	}
}
