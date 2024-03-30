package com.daniel.backend.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_motorista")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MotoristaEntity extends RepresentationModel<MotoristaEntity> implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_motorista;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String categoria;
}
