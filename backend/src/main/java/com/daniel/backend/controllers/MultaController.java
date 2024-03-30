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

import com.daniel.backend.dtos.MultaRecordDTO;
import com.daniel.backend.models.MultaEntity;
import com.daniel.backend.services.MultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("multa")
public class MultaController {
    @Autowired
    private MultaService multaService;

    @PostMapping
    public ResponseEntity<MultaEntity> saveMulta(@RequestBody @Valid MultaRecordDTO multaRecordDTO) {
        return multaService.saveMulta(multaRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<MultaEntity>> getAllMultas() {
        return multaService.getAllMultas();
    }

    @GetMapping("{id_multa}")
    public ResponseEntity<Object> getOneMulta(@PathVariable(value = "id_multa")Long id_multa) {
        return multaService.getOneMulta(id_multa);
    }

    @PutMapping("{id_multa}")
    public ResponseEntity<Object> updateMulta(@PathVariable(value = "id_multa")Long id_multa, @RequestBody @Valid MultaRecordDTO multaRecordDTO) {
        return multaService.updateMulta(id_multa, multaRecordDTO);
    }

    @DeleteMapping("{id_multa}")
    public ResponseEntity<Object> deleteMulta(@PathVariable(value = "id_multa")Long id_multa) {
        return multaService.deleteMulta(id_multa);
    }
}
