package com.daniel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.backend.models.MultaEntity;

public interface MultaRepository extends JpaRepository<MultaEntity, Long>{
    
}
