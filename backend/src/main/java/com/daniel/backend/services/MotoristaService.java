package com.daniel.backend.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.daniel.backend.controllers.MotoristaController;
import com.daniel.backend.dtos.MotoristaRecordDTO;
import com.daniel.backend.models.MotoristaEntity;
import com.daniel.backend.repositories.MotoristaRepository;

@Service
public class MotoristaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    public ResponseEntity<MotoristaEntity> saveMotorista(MotoristaRecordDTO motoristaRecordDTO) {
        MotoristaEntity motoristaEntity = new MotoristaEntity();
        BeanUtils.copyProperties(motoristaRecordDTO, motoristaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaRepository.save(motoristaEntity));
    }

    public ResponseEntity<List<MotoristaEntity>> getAllMotoristas() {
        List<MotoristaEntity> motoristaList = motoristaRepository.findAll();
        if(!motoristaList.isEmpty()) {
            for(MotoristaEntity motoristaEntity : motoristaList) {
                Long id_motorista = motoristaEntity.getId_motorista();
                motoristaEntity.add(linkTo(methodOn(MotoristaController.class).getOneMotorista(id_motorista)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(motoristaList);
    }

    public ResponseEntity<Object> getOneMotorista(Long id_motorista) {
        Optional<MotoristaEntity> motoristaOne = motoristaRepository.findById(id_motorista);
        if(motoristaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum motorista com este id");
        }
        motoristaOne.get().add(linkTo(methodOn(MotoristaController.class).getAllMotoristas()).withRel("Lista de motoristas"));
        return ResponseEntity.status(HttpStatus.OK).body(motoristaOne);
    }

    public ResponseEntity<Object> updateMotorista(Long id_motorista, MotoristaRecordDTO motoristaRecordDTO) {
        Optional<MotoristaEntity> motoristaOne = motoristaRepository.findById(id_motorista);
        if(motoristaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum motorista com este id");
        }
        MotoristaEntity motoristaEntity = motoristaOne.get();
        BeanUtils.copyProperties(motoristaRecordDTO, motoristaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(motoristaRepository.save(motoristaEntity));
    }

    public ResponseEntity<Object> deleteMotorista(Long id_motorista) {
        Optional<MotoristaEntity> motoristaOne = motoristaRepository.findById(id_motorista);
        if(motoristaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum motorista com este id");
        }
        motoristaRepository.delete(motoristaOne.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
