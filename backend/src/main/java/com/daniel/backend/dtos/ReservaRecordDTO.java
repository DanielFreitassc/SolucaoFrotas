package com.daniel.backend.dtos;

import java.time.LocalDateTime;

import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.models.VeiculoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservaRecordDTO(
    @NotNull LocalDateTime reservado,
    @NotNull LocalDateTime saida,
    @NotNull LocalDateTime chegada, 
    VeiculoEntity veiculo, 
    MotoristaEntity motorista,
    @NotBlank String organograma,
    @NotBlank String finalidade, 
    String observacoes) {
    
}
