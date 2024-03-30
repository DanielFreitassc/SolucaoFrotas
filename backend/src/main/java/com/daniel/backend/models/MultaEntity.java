package com.daniel.backend.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_multas")
public class MultaEntity extends RepresentationModel<MultaEntity> implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_multa;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private VeiculoEntity veiculo;
    private LocalDateTime multado_em;
    @ManyToOne
    @JoinColumn(name = "id_motorista")
    private MotoristaEntity motorista;
    private String num_notificacao;
    private LocalDateTime vencimento;
    private String observacao;
    private String local;
    private String municipio;
    private String bairro;
    private String logradouro;
    private String complemento;
    private String infracao;
    private BigDecimal valor;
    private LocalDateTime recurso;
    private String situacao;
    private LocalDateTime data_pagamento;
    private BigDecimal valor_juros;
    private BigDecimal valor_desconto;
    private BigDecimal valor_pago;
}
