package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}
