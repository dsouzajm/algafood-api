package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value="/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {

	@Autowired
	private CadastroEstadoService estadoService;

	@GetMapping
	public List<Estado> listar() {
		
		return estadoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		
		try {
			
			Estado estado = estadoService.buscar(id);
			return  ResponseEntity.ok(estado);
			
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());			
		}				
	}
	
	@PostMapping
	public ResponseEntity<Estado> salvar(@RequestBody Estado estado){

		Estado estadoSalvo = estadoService.salvar(estado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		try {
			estadoService.remover(id);
			return ResponseEntity.ok().build();
			
		} catch (EntidadeEmUsoException e) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
			
		} catch (EntidadeNaoEncontradaException e) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}				
	}
}
