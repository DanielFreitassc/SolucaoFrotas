package com.daniel.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record MotoristaRecordDTO(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String cpf, @NotBlank String categoria) {
    
}
