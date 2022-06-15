package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;

	@GetMapping
	public ResponseEntity<List<Restaurante>> listar() {

		return new ResponseEntity<List<Restaurante>>(cadastroRestauranteService.listar()
				, HttpStatus.OK);		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {

		return new ResponseEntity<Restaurante>(cadastroRestauranteService.buscar(id)
				, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {

		try {
			
			return new ResponseEntity<Restaurante>(cadastroRestauranteService.atualizar(id, restaurante)
					, HttpStatus.OK);			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<Restaurante> adicionar(@RequestBody Restaurante restaurante) {

		try {
			
			return new ResponseEntity<Restaurante>(cadastroRestauranteService.adicionar(restaurante)
					, HttpStatus.CREATED);						
		} catch (EntidadeNaoEncontradaException e) {
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurante> excluir(@PathVariable Long id) {
		
		try {
			
			cadastroRestauranteService.excluir(id);			
			return new ResponseEntity<Restaurante>(HttpStatus.OK);
		} catch (EntidadeNaoEncontradaException e) {
			
			return new ResponseEntity<Restaurante>(HttpStatus.NOT_FOUND);
		}
	}
}
