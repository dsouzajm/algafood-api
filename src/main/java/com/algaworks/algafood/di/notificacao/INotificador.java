package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;

public interface INotificador {
	void notificar(Cliente cliente, String mensagem);
}