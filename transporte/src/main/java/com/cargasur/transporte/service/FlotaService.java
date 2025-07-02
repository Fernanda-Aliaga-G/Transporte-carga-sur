package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Flota;
import com.cargasur.transporte.repository.FlotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlotaService {

    @Autowired
    private FlotaRepository flotaRepository;

    public List<Flota> obtenerFlotaDisponible() {
        return flotaRepository.findByDisponibleTrueAndEstadoTecnico("operativo");
    }
    public String verificarEstadoTecnico(String patente) {
        return flotaRepository.findByPatente(patente)
                .map(flota -> {
                    if ("operativo".equalsIgnoreCase(flota.getEstadoTecnico())) {
                        return "Camión habilitado para operar";
                    } else {
                        return "Camión no habilitado";
                    }
                })
                .orElse("Camión no encontrado");
    }
    public List<Flota> obtenerMantencionesPendientes() {
        LocalDate hoy = LocalDate.now();
        return flotaRepository.findByFechaProximaMantencionBefore(hoy.plusDays(7));
    }

}
