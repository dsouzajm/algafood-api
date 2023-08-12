package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "grupo_permissao",
               joinColumns = @JoinColumn(name = "grupo_id"),
               inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Grupo> grupos = new ArrayList<>();
}
