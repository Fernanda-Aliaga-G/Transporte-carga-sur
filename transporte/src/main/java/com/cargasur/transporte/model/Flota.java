package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Flota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String ubicacion;
    private Integer capacidad;
    private String estadoTecnico;
    private boolean disponible;  // <- CAMBIADO A boolean
    private LocalDate fechaProximaMantencion;


}
