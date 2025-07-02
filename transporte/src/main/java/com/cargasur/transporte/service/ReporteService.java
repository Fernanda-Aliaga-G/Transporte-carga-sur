package com.cargasur.transporte.service;

import com.cargasur.transporte.repository.OrdenRepository;
import com.cargasur.transporte.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public Map<String, Object> generarReporteSimple() {
        long totalOrdenes = ordenRepository.count();
        long totalIncidentes = eventoRepository.count(); // Más adelante puedes filtrar solo tipo INCIDENTE

        return Map.of(
                "totalOrdenes", totalOrdenes,
                "totalIncidentes", totalIncidentes
        );
    }
}
