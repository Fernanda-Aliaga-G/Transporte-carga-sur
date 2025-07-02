package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Entrega;
import com.cargasur.transporte.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega confirmarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }
}
