package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Flota;
import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.repository.FlotaRepository;
import com.cargasur.transporte.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;


@Service
public class FlotaService {

    @Autowired
    private FlotaRepository flotaRepository;

    @Autowired
    private OrdenRepository ordenRepository;

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

    public void asignarAutomatica(Long ordenId) {
        Optional<Orden> ordenOpt = ordenRepository.findById(ordenId);
        if (ordenOpt.isEmpty()) {
            throw new IllegalArgumentException("Orden con ID " + ordenId + " no encontrada");
        }

        Orden orden = ordenOpt.get();

        Optional<Flota> flotaOpt = flotaRepository.findAll().stream()
                .filter(f -> f.isDisponible() && "operativo".equalsIgnoreCase(f.getEstadoTecnico()))
                .findFirst();

        if (flotaOpt.isEmpty()) {
            throw new IllegalStateException("No hay flotas disponibles para asignar");
        }

        Flota flota = flotaOpt.get();

        // Asignamos la flota a la orden
        orden.setFlota(flota);
        ordenRepository.save(orden);

        // Cambiamos estado de disponibilidad del camión
        flota.setDisponible(false);
        flotaRepository.save(flota);
    }

}
