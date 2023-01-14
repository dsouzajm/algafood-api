package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> listar(){

        return cidadeRepository.findAll();
    }

    public Cidade buscar(Long id){

        return cidadeRepository.findById(id)
                               .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cozinha com o código %d.", id)));
    }

    public Cidade atualizar(Long id, Cidade cidade){

        Long estadoId = cidade.getEstado().getId();

        Estado estadoTarget = estadoRepository.findById(estadoId)
                                              .orElseThrow(() -> new PropriedadeNaoEncontradaException(String.format("Não existe estado com o código %d.", estadoId)));

        Cidade cidadeTarget = cidadeRepository.findById(id)
                                              .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cozinha com o código %d.", id)));

        BeanUtils.copyProperties(cidade, cidadeTarget, "id");

        return cidadeRepository.save(cidadeTarget);
    }

    public Cidade salvar(Cidade cidade){

        Long estadoId = cidade.getEstado().getId();

        Estado estadoTarget = estadoRepository.findById(estadoId)
                                              .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe estado com o código %d.", estadoId)));

        cidade.setEstado(estadoTarget);

        return cidadeRepository.save(cidade);
    }

    public void excluir(Long id){

        try {

            cidadeRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {

            throw new EntidadeNaoEncontradaException(String.format("Não existe cidade com o código %d.", id));
        }
    }
}
