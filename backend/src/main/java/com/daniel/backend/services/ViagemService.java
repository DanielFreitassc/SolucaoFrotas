package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.daniel.backend.controllers.ViagemController;
import com.daniel.backend.dtos.ViagemRecordDTO;
import com.daniel.backend.models.ViagemEntity;
import com.daniel.backend.repositories.ViagemRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ViagemService {
    @Autowired
    private ViagemRepository viagemRepository;

    public ResponseEntity<ViagemEntity> saveViagem(ViagemRecordDTO viagemRecordDTO) {
        ViagemEntity viagemEntity = new ViagemEntity();
        BeanUtils.copyProperties(viagemRecordDTO, viagemEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagemEntity));
    }

    public ResponseEntity<List<ViagemEntity>> getAllViagens() {
        List<ViagemEntity> viagemList = viagemRepository.findAll();
        if(!viagemList.isEmpty()) {
            for(ViagemEntity viagemEntity : viagemList) {
                Long id_viagem = viagemEntity.getId_viagem();
                viagemEntity.add(linkTo(methodOn(ViagemController.class).getOneViagem(id_viagem)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(viagemList);
    }

    public ResponseEntity<Object> getOneViagem(Long id_viagem) {
        Optional<ViagemEntity> viagemOne = viagemRepository.findById(id_viagem);
        if(viagemOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma viagem com este id");
        }
        viagemOne.get().add(linkTo(methodOn(ViagemController.class).getAllViagens()).withRel("Lista de viagens"));
        return ResponseEntity.status(HttpStatus.OK).body(viagemOne);
    }

    public ResponseEntity<Object> updateViagem(Long id_viagem, ViagemRecordDTO viagemRecordDTO) {
        Optional<ViagemEntity> viagemOne = viagemRepository.findById(id_viagem);
        if(viagemOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma viagem com este id");
        }
        ViagemEntity viagemEntity = viagemOne.get();
        BeanUtils.copyProperties(viagemRecordDTO, viagemEntity);
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(viagemEntity));
    }

    public ResponseEntity<Object> deleteViagem(Long id_viagem) {
        Optional<ViagemEntity> viagemOne = viagemRepository.findById(id_viagem);
        if(viagemOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum viagem com este id");
        }
        viagemRepository.delete(viagemOne.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }    
}
