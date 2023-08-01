package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public List<Cidade> listar() {
        return cadastroCidadeService.listar();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
        try {
            Cidade cidade = cadastroCidadeService.buscar(id);
            return ResponseEntity.ok(cidade);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        try {
            Cidade cidadePersistida = cadastroCidadeService.salvar(cidade);
            return ResponseEntity.ok(cidade);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody Cidade cidade) {
        try {
            Cidade cidadePersistida = cadastroCidadeService.atualizar(id, cidade);
            return ResponseEntity.ok(cidadePersistida);

        } catch (PropriedadeNaoEncontradaException | EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        try {
            cadastroCidadeService.excluir(id);
            return ResponseEntity.ok().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}