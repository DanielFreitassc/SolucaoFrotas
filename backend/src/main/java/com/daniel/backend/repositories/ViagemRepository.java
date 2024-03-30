package com.daniel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.backend.models.ViagemEntity;



public interface ViagemRepository extends JpaRepository<ViagemEntity,Long>{
    
}
