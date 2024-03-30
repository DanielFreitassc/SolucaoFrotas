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

import com.daniel.backend.dtos.ViagemRecordDTO;
import com.daniel.backend.models.ViagemEntity;
import com.daniel.backend.services.ViagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("viagem")
public class ViagemController {
    @Autowired
    private ViagemService viagemService;

    @PostMapping
    public ResponseEntity<ViagemEntity> saveViagem(@RequestBody @Valid ViagemRecordDTO viagemRecordDTO) {
        return viagemService.saveViagem(viagemRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<ViagemEntity>> getAllViagens() {
        return viagemService.getAllViagens();
    }

    @GetMapping("{id_viagem}")
    public ResponseEntity<Object> getOneViagem(@PathVariable(value = "id_viagem")Long id_viagem) {
        return viagemService.getOneViagem(id_viagem);
    }

    @PutMapping("{id_viagem}")
    public ResponseEntity<Object> updateViagem(@PathVariable(value = "id_viagem")Long id_viagem, @RequestBody @Valid ViagemRecordDTO viagemRecordDTO) {
        return viagemService.updateViagem(id_viagem, viagemRecordDTO);
    }
    
    @DeleteMapping("{id_viagem}")
    public ResponseEntity<Object> deleteViagem(@PathVariable(value = "id_viagem")Long id_viagem) {
        return viagemService.deleteViagem(id_viagem);
    }
}
