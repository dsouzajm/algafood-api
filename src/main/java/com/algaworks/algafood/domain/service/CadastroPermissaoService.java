package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroPermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;
    public List<Permissao> listar(){
        return permissaoRepository.listar();
    }
}
