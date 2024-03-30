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

import com.daniel.backend.dtos.ReservaRecordDTO;
import com.daniel.backend.models.ReservaEntity;
import com.daniel.backend.services.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;


    @PostMapping
    public ResponseEntity<ReservaEntity> saveReserva(@RequestBody @Valid ReservaRecordDTO reservaRecordDTO) {
        return reservaService.saveReserva(reservaRecordDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<ReservaEntity>> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("{id_reserva}")
    public ResponseEntity<Object> getOneReserva(@PathVariable(value = "id_reserva") Long id_reserva) {
        return reservaService.getOneReserva(id_reserva);
    } 

    @PutMapping("{id_reserva}")
    public ResponseEntity<Object> updateReserva(@PathVariable(value = "id_reserva")Long id_reserva, @RequestBody @Valid ReservaRecordDTO recordDTO) {
        return reservaService.updateReserva(id_reserva, recordDTO);
    }

    @DeleteMapping("{id_reserva}")
    public ResponseEntity<Object> deleteReserva(@PathVariable(value = "id_reserva")Long id_reserva) {
        return reservaService.deleteReserva(id_reserva);
    }



    
}
