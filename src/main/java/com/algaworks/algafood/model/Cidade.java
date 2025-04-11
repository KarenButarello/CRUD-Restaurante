package com.algaworks.algafood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Cidade")
public class Cidade {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cidade", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "Estado", nullable = false)
    private Estado estadoId;
}
