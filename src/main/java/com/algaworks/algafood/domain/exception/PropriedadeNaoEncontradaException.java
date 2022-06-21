package com.algaworks.algafood.domain.exception;

public class PropriedadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PropriedadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
