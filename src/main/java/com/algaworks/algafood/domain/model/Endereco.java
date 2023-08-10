package com.algaworks.algafood.domain.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Endereco {
    @Column(name="endereco_cep")
    private String cep;
    @Column(name="endereco_logradouro")
    private String logradouro;
    @Column(name="endereco_numero")
    private String numero;
    @Column(name="endereco_complemento")
    private String complemento;
}
