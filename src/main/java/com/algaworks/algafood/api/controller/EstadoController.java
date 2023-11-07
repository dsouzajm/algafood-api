package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
	public ResponseEntity<?> excluir(@PathVariable Long id){
		try {
			estadoService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}				
	}
}