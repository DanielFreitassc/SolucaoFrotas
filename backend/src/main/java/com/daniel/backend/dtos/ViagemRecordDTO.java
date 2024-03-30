package com.daniel.backend.dtos;

import java.time.LocalDateTime;

import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.models.ReservaEntity;
import com.daniel.backend.models.VeiculoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ViagemRecordDTO(
    ReservaEntity reserva,
    @NotNull LocalDateTime chegada, 
    @NotNull LocalDateTime saida, 
    @NotNull LocalDateTime registro, 
    VeiculoEntity veiculo, 
    MotoristaEntity motorista,
    @NotBlank String organograma,
    @NotBlank String responsavel, 
    @NotBlank String finalidade, 
    @NotBlank String observacao, 
    @NotBlank String rota,
    @NotNull double saida_km, 
    @NotNull double chegada_km, 
    @NotNull double estimada, 
    @NotNull double realizada, 
    @NotNull double diferenca) {
    
}
