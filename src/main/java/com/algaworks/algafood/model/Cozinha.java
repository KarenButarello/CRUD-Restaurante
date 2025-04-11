package com.algaworks.algafood.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Cozinha")
public class Cozinha {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cozinha", nullable = false)
    private String nome;

}
