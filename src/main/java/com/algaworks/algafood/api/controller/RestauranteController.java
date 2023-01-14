package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeNaoEncontradaException;
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

		try {
			
			Restaurante restaurante = cadastroRestauranteService.buscar(id);		
			return new ResponseEntity<Restaurante>(restaurante, HttpStatus.OK);
	
		} catch (EntidadeNaoEncontradaException e) {
			
			return new ResponseEntity<Restaurante>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {

		try {
			
			return new ResponseEntity<Restaurante>(
					cadastroRestauranteService.atualizar(id, restaurante)
					, HttpStatus.OK);
			
		} catch (PropriedadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());			
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarParcialmente(@PathVariable Long id, @RequestBody Map<String, Object> campos){

		Restaurante restauranteAtual = cadastroRestauranteService.buscar(id);
		System.out.println("RestauranteAtual = " + restauranteAtual);

		if(restauranteAtual == null){
			return ResponseEntity.notFound().build();
		}

		merge(campos, restauranteAtual);

		return new ResponseEntity<Restaurante>(cadastroRestauranteService.atualizar(id, restauranteAtual), HttpStatus.OK);
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino){

		ObjectMapper mapper = new ObjectMapper();
		Restaurante restauranteOrigem = mapper.convertValue(dadosOrigem, Restaurante.class);

		System.out.println(dadosOrigem);

		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {

			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);

			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {

		try {
			
			return new ResponseEntity<Restaurante>(cadastroRestauranteService.adicionar(restaurante)
					, HttpStatus.CREATED);						
		} catch (PropriedadeNaoEncontradaException e) {
		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		
		try {
			
			cadastroRestauranteService.excluir(id);			
			return new ResponseEntity<Restaurante>(HttpStatus.NO_CONTENT);
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
