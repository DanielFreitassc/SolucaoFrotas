package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.daniel.backend.controllers.MultaController;
import com.daniel.backend.dtos.MultaRecordDTO;
import com.daniel.backend.models.MultaEntity;
import com.daniel.backend.repositories.MultaRepository;

@Service
public class MultaService {
    @Autowired
    private MultaRepository multaRepository;

    public ResponseEntity<MultaEntity> saveMulta(MultaRecordDTO multaRecordDTO) {
        MultaEntity multaEntity = new MultaEntity();
        BeanUtils.copyProperties(multaRecordDTO, multaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(multaRepository.save(multaEntity));
    }

    public ResponseEntity<List<MultaEntity>> getAllMultas() {
        List<MultaEntity> multaList = multaRepository.findAll();
        if(!multaList.isEmpty()) {
            for(MultaEntity multaEntity : multaList) {
                Long id_multa = multaEntity.getId_multa();
                multaEntity.add(linkTo(methodOn(MultaController.class).getOneMulta(id_multa)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(multaList);
    }

    public ResponseEntity<Object> getOneMulta(Long id_multa) {
        Optional<MultaEntity> multaOne = multaRepository.findById(id_multa);
        if(multaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum multa com este id");
        }
        multaOne.get().add(linkTo(methodOn(MultaController.class).getAllMultas()).withRel("Lista de multas"));
        return ResponseEntity.status(HttpStatus.OK).body(multaOne);
    }
    
    public ResponseEntity<Object> updateMulta(Long id_multa, MultaRecordDTO multaRecordDTO) {
        Optional<MultaEntity> multaOne = multaRepository.findById(id_multa);
        if(multaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum multa com este id");
        }
        MultaEntity multaEntity = new MultaEntity();
        BeanUtils.copyProperties(multaRecordDTO, multaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(multaRepository.save(multaEntity));
    }

    public ResponseEntity<Object> deleteMulta(Long id_multa) {
        Optional<MultaEntity> multaOne = multaRepository.findById(id_multa);
        if(multaOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum multa com este id");
        }
        multaRepository.delete(multaOne.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
