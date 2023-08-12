package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    private CadastroGrupoService cadastroGrupoService;
    @GetMapping
    public ResponseEntity<?> listar(){
        List<Grupo> grupos = cadastroGrupoService.listar();
        return ResponseEntity.ok(grupos);
    }
}
