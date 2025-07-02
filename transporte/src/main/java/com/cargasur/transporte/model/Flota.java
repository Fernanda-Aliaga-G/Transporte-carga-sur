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

    public boolean isDisponible() {
        return disponible;
    }

    private String patente;
    private String ubicacion;
    private Integer capacidad;
    private String estadoTecnico;
    private Boolean disponible;
    private LocalDate fechaProximaMantencion;
}
