package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.daniel.backend.controllers.ReservaController;
import com.daniel.backend.dtos.ReservaRecordDTO;
import com.daniel.backend.models.ReservaEntity;
import com.daniel.backend.repositories.ReservaRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.validation.Valid;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public ResponseEntity<ReservaEntity> saveReserva(@RequestBody @Valid ReservaRecordDTO reservaRecordDTO) {
        ReservaEntity reservaEntity = new ReservaEntity();
        BeanUtils.copyProperties(reservaRecordDTO, reservaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaRepository.save(reservaEntity));
    }

    public ResponseEntity<List<ReservaEntity>> getAllReservas() {
        List<ReservaEntity> reservaList = reservaRepository.findAll();
        if(!reservaList.isEmpty()) {
            for(ReservaEntity reservaEntity : reservaList) {
                Long id_reserva = reservaEntity.getId_reserva();
                reservaEntity.add(linkTo(methodOn(ReservaController.class).getOneReserva(id_reserva)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservaList);
    }

    public ResponseEntity<Object> getOneReserva(Long id_reserva) {
        Optional<ReservaEntity> reservaOne = reservaRepository.findById(id_reserva);
        if(reservaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum reserva com este id");
        }
        reservaOne.get().add(linkTo(methodOn(ReservaController.class).getAllReservas()).withRel("Lista de reservas"));
        return ResponseEntity.status(HttpStatus.OK).body(reservaOne);
    }

    public ResponseEntity<Object> updateReserva(Long id_reserva, ReservaRecordDTO reservaRecordDTO) {
        Optional<ReservaEntity> reservaOne = reservaRepository.findById(id_reserva);
        if(reservaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma reserva com este id");
        }
        ReservaEntity reservaEntity = reservaOne.get();
        BeanUtils.copyProperties(reservaRecordDTO, reservaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(reservaRepository.save(reservaEntity));
    }

    public ResponseEntity<Object> deleteReserva(Long id_reserva) {
        Optional<ReservaEntity> reservaOne = reservaRepository.findById(id_reserva);
        if(reservaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum reserva com este id");
        }
        reservaRepository.delete(reservaOne.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
