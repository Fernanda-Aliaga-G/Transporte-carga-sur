package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long camionId; // O bien una relación con Flota más adelante
    private Long ordenId;
    private String ubicacionInicio;
    private LocalDateTime fechaHoraInicio;
}
