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

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_viagem")
public class ViagemEntity extends RepresentationModel<VeiculoEntity> implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_viagem;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private ReservaEntity reserva;
    private LocalDateTime chegada;
    private LocalDateTime saida;
    private LocalDateTime registro;
    @OneToOne
    @JoinColumn(name = "id_veiculo")
    private VeiculoEntity veiculo;
    @OneToOne
    @JoinColumn(name = "id_motorista")
    private MotoristaEntity motorista;
    private String organograma;
    private String responsavel;
    private String finalidade;
    private String observacao;
    private String rota;
    private double saida_km;
    private double chegada_km;
    private double estimada;
    private double realizada;
    private double diferenca;
}
