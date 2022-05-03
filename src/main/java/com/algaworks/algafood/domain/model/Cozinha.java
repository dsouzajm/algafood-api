package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cozinha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	@EqualsAndHashCode.Exclude
	private String nome;
}
