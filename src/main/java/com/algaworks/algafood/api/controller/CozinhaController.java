package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar() {
		System.out.println("CHAMOU JSON");		
		return cadastroCozinhaService.listar();
	}		
	/*@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaWrapperXML listarXml() {
		
		System.out.println("CHAMOU XML");		
		return new CozinhaWrapperXML(cadastroCozinhaService.listar());
	}*/		
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		Cozinha cozinha = cadastroCozinhaService.buscar(id);
		if(cozinha != null){
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/nao_existe")
	public ResponseEntity<Cozinha> buscarCaminhoRemovido() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");
		return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).headers(headers).build();
	}
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinhaService.salvar(cozinha);		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){
		try {
			Cozinha cozinhaAtual = cadastroCozinhaService.atualizar(id, cozinha);
			return ResponseEntity.ok(cozinhaAtual);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> excluir(@PathVariable Long id){
		try {
			cadastroCozinhaService.excluir(id);			
			return ResponseEntity.ok().build();
		} catch (EntidadeNaoEncontradaException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}