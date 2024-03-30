package com.daniel.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoRecordDTO(
    @NotBlank String placa, 
    @NotBlank String modelo,
    @NotBlank String categoria, 
    @NotBlank String ano, 
    @NotBlank String cor, 
    @NotNull double quilometragem, 
    @NotBlank String numero_de_chassi) {
    
}
