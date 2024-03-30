package com.daniel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.backend.models.MotoristaEntity;

public interface MotoristaRepository extends JpaRepository<MotoristaEntity,Long> {
    
}
