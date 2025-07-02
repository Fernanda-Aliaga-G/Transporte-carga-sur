package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ordenId;
    private LocalDateTime fechaEmision;
    private Double montoTotal;
    private String numeroFactura; // Ej: "FAC-0001"
}
