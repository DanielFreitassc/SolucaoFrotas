package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.daniel.backend.controllers.VeiculoController;
import com.daniel.backend.dtos.VeiculoRecordDTO;
import com.daniel.backend.models.VeiculoEntity;
import com.daniel.backend.repositories.VeiculoRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public ResponseEntity<VeiculoEntity> saveVeiculo(VeiculoRecordDTO veiculoRecordDTO) {
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        BeanUtils.copyProperties(veiculoRecordDTO, veiculoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(veiculoEntity));
    }

    public ResponseEntity<List<VeiculoEntity>> getAllVeiculos() {
        List<VeiculoEntity> veiculoList = veiculoRepository.findAll();
        if(!veiculoList.isEmpty()) {
            for(VeiculoEntity veiculoEntity : veiculoList) {
                Long id_veiculo = veiculoEntity.getId_veiculo();
                veiculoEntity.add(linkTo(methodOn(VeiculoController.class).getOneVeiculo(id_veiculo)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(veiculoList);
    }

    public ResponseEntity<Object> getOneVeiculo(Long id_veiculo) {
        Optional<VeiculoEntity> veiculoOne = veiculoRepository.findById(id_veiculo);
        if(veiculoOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum veiculo com este id");
        }
        veiculoOne.get().add(linkTo(methodOn(VeiculoController.class).getAllVeiculos()).withRel("Lista de veiculos"));
        return ResponseEntity.status(HttpStatus.OK).body(veiculoOne);
    }
    
    public ResponseEntity<Object> updateVeiculo(Long id_veiculo, VeiculoRecordDTO veiculoRecordDTO) {
        Optional<VeiculoEntity> veiculoOne = veiculoRepository.findById(id_veiculo);
        if(veiculoOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum veiculo com este id");
        }
        VeiculoEntity veiculoEntity = veiculoOne.get();
        BeanUtils.copyProperties(veiculoRecordDTO, veiculoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculoEntity));
    }

    public ResponseEntity<Object> deleteVeiculo(Long id_veiculo) {
        Optional<VeiculoEntity> veiculoOne = veiculoRepository.findById(id_veiculo);
        if(veiculoOne.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum veiculo com este id");
        }
        veiculoRepository.delete(veiculoOne.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
