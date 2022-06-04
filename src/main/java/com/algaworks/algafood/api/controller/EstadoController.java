package com.algaworks.algafood.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.repository.EstadoRepository;

@RestController
@RequestMapping(value="/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> listar() {
		
		return estadoRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscar(@PathVariable long id) {
		
		Estado estado = estadoRepository.buscar(id);
		
		if(estado != null) {
			
			return ResponseEntity.ok(estado);	 
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@PostMapping
	public ResponseEntity<Estado> salvar(@RequestBody Estado estado){
	
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoRepository.salvar(estado));		
	}
}
