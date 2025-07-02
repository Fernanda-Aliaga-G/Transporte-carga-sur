package com.cargasur.transporte.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long viajeId;
    private LocalDateTime fechaEntrega;
    private String receptor;
    private String firmaDigital;
}
