package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long viajeId;
    private LocalDateTime fechaEvento;
    private String tipoEvento;
    private String descripcion;
    private String ubicacion;
}
