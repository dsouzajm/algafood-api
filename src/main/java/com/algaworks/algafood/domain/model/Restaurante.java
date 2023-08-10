package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@EqualsAndHashCode.Exclude
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "taxa_frete", nullable = false)
	@EqualsAndHashCode.Exclude
	private BigDecimal taxaFrete;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cozinha_id", nullable = false)
	@EqualsAndHashCode.Exclude
	private Cozinha cozinha;

	@ManyToMany
	@JoinTable(name = "restaurante_forma_pagamento",
			   joinColumns = @JoinColumn(name = "restaurante_id"),
			   inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formaPagamento = new ArrayList<>();

	@Embedded
	private Endereco endereco;

	@Override
	public String toString() {
		return "Restaurante{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", taxaFrete=" + taxaFrete +
				", cozinha=" + cozinha +
				'}';
	}
}
