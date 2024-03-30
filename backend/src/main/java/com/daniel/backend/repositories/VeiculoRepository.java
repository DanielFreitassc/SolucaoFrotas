package com.daniel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.backend.models.VeiculoEntity;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
    
}
