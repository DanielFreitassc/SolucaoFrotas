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

import com.daniel.backend.dtos.VeiculoRecordDTO;
import com.daniel.backend.models.VeiculoEntity;
import com.daniel.backend.services.VeiculoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoEntity> saveVeiculo(@RequestBody @Valid VeiculoRecordDTO veiculoRecordDTO) {
        return veiculoService.saveVeiculo(veiculoRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoEntity>> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("{id_veiculo}")
    public ResponseEntity<Object> getOneVeiculo(@PathVariable(value = "id_veiculo")Long id_veiculo) {
        return veiculoService.getOneVeiculo(id_veiculo);
    }

    @PutMapping("{id_veiculo}")
    public ResponseEntity<Object> updateVeiculo(@PathVariable(value = "id_veiculo")Long id_veiculo, @RequestBody @Valid VeiculoRecordDTO veiculoRecordDTO) {
        return veiculoService.updateVeiculo(id_veiculo, veiculoRecordDTO);
    }

    @DeleteMapping("{id_veiculo}")
    public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "id_veiculo")Long id) {
        return veiculoService.deleteVeiculo(id);
    }
}
