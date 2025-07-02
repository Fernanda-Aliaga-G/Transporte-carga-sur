package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String password; // En sistemas reales, debería ir encriptada
}
