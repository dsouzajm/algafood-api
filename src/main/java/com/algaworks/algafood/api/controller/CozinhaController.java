package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhaWrapperXML;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.repository.CozinhaRepository;

import sun.jvm.hotspot.memory.HeapBlock.Header;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository; 
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar() {
		
		System.out.println("CHAMOU JSON");
		return cozinhaRepository.listar();
	}		
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaWrapperXML listarXml() {
		
		System.out.println("CHAMOU XML");		
		return new CozinhaWrapperXML(cozinhaRepository.listar());
	}		
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		
		Cozinha cozinha = cozinhaRepository.buscar(id);
		
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
	
}
