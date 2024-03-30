package com.daniel.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_reserva")
public class ReservaEntity extends RepresentationModel<ReservaEntity> implements Serializable {
    private static final Long serialVersionUID  = 1L;

    @Id
    @EqualsAndHashCode.Include 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;
    private LocalDateTime saida;
    private LocalDateTime chegada;
    @OneToOne
    @JoinColumn(name = "id_veiculo")
    private VeiculoEntity veiculo; 
    @OneToOne
    @JoinColumn(name = "id_motorista")
    private MotoristaEntity motorista;
    private String organograma;
    private String finalidade;
    private String observacoes;
}
