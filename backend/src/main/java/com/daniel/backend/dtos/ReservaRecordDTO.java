package com.daniel.backend.dtos;

import java.time.LocalDateTime;

import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.models.VeiculoEntity;

public record ReservaRecordDTO(LocalDateTime reservado, LocalDateTime saida, LocalDateTime chegada, VeiculoEntity veiculo, MotoristaEntity motoristaEntity, String organograma, String finalidade, String observacoes) {
    
}
