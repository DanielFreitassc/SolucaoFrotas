package com.daniel.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.backend.dtos.MotoristaRecordDTO;
import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.services.MotoristaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("motorista")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<MotoristaEntity> saveMotorista(@RequestBody @Valid MotoristaRecordDTO motoristaRecordDTO) {
        return motoristaService.saveMotorista(motoristaRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<MotoristaEntity>> getAllMotoristas() {
        return motoristaService.getAllMotoristas();
    }

    @GetMapping("{id_motorista}")
    public ResponseEntity<Object> getOneMotorista(@PathVariable(value = "id_motorista")Long id_motorista) {
        return motoristaService.getOneMotorista(id_motorista);
    }

    @PutMapping("{id_motorista}")
    public ResponseEntity<Object> updateMotorista(@PathVariable(value = "id_motorista")Long id_motorista, @RequestBody @Valid MotoristaRecordDTO motoristaRecordDTO) {
        return motoristaService.updateMotorista(id_motorista, motoristaRecordDTO);
    }

    @DeleteMapping("{id_motorista}")
    public ResponseEntity<Object> deleteMotorista(@PathVariable(value = "id_motorista")Long id_motorista) {
        return motoristaService.deleteMotorista(id_motorista);
    }
    
}
