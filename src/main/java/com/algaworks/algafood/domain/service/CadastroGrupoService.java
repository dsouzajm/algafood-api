package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }
}
