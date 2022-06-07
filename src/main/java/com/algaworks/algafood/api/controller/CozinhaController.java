package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhaWrapperXML;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

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
		
		return ResponseEntity.notFound().build();		
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
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){
		
		Cozinha cozinhaAtual = cadastroCozinhaService.atualizar(id, cozinha);
		
		if(cozinhaAtual != null) {
			
			return ResponseEntity.ok(cozinhaAtual);
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> excluir(@PathVariable Long id){
		
		try {
		
			cadastroCozinhaService.excluir(id);			
			return ResponseEntity.noContent().build(); 	
			
		} catch (EntidadeNaoEncontradaException e) {
			
			System.out.println(e);
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
