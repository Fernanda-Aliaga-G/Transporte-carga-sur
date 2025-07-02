package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public Orden guardarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public String obtenerEstadoOrden(Long id) {
        return ordenRepository.findById(id)
                .map(Orden::getEstado)
                .orElse("Orden no encontrada");
    }
}