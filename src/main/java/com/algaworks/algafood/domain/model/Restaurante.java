package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private String nome;
	
	@Column(name = "taxa_frete")
	@EqualsAndHashCode.Exclude
	private BigDecimal taxaFrete;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	private Cozinha cozinha;
}
