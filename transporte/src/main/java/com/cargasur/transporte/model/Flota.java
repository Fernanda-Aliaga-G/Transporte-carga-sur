package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private Boolean disponible;
    private LocalDate fechaProximaMantencion;
}
