package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flota_id")
    private Flota flota;

    private String cliente;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private String estado;
}
