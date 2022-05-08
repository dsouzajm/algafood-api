package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "formaPagamento1")
@Getter
@Setter
@EqualsAndHashCode
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@EqualsAndHashCode.Exclude
	@Column(nullable = false)
	private String descricao;
}
