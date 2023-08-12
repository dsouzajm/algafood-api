package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private CadastroPermissaoService cadastroPermissaoService;
    @GetMapping
    public ResponseEntity<?> listar(){
        List<Permissao> permissoes = cadastroPermissaoService.listar();
        return ResponseEntity.ok(permissoes);
    }
}
