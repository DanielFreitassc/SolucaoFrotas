package com.daniel.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.models.VeiculoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MultaRecordDTO(
    VeiculoEntity veiculo,
    @NotNull LocalDateTime multado_em,
    MotoristaEntity motorista,
    @NotBlank String num_notificacao,
    @NotNull LocalDateTime vencimento,
    String observacao,
    @NotBlank String local,
    @NotBlank String municipio,
    @NotBlank String bairro,
    @NotBlank String logradouro,
    @NotBlank String complemento,
    @NotBlank String infracao,
    @NotNull BigDecimal valor,
    @NotNull LocalDateTime recurso,
    @NotBlank String situacao,
    @NotNull LocalDateTime data_pagamento,
    @NotNull BigDecimal valor_juros,
    @NotNull BigDecimal valor_desconto,
    @NotNull BigDecimal valor_pago
) {
    
}
