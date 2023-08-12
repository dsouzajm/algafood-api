package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@JsonRootName("cozinha")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JacksonXmlRootElement(localName = "cozinha")
public class Cozinha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	//@JsonProperty("titulo")
	@Column(nullable = false)
	private String nome;
}
