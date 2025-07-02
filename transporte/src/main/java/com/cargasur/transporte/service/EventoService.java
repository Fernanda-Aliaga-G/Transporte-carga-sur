package com.cargasur.transporte.service;
import com.cargasur.transporte.repository.ViajeRepository;

import com.cargasur.transporte.model.Evento;
import com.cargasur.transporte.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ViajeRepository viajeRepository;

    public Evento registrarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
    public String obtenerUbicacionActual(Long viajeId) {
        List<Evento> eventos = eventoRepository.findByViajeIdOrderByFechaEventoDesc(viajeId);
        if (!eventos.isEmpty()) {
            return eventos.get(0).getUbicacion(); // Última ubicación registrada
        }
        return "Ubicación no disponible";
    }
    public List<Evento> obtenerEventosPorOrden(Long ordenId) {
        return viajeRepository.findByOrdenId(ordenId)
                .map(viaje -> eventoRepository.findByViajeIdOrderByFechaEventoAsc(viaje.getId()))
                .orElse(List.of());
    }
    public List<Evento> obtenerEventosPorOrden(Long ordenId) {
        return viajeRepository.findByOrdenId(ordenId)
                .map(viaje -> eventoRepository.findByViajeIdOrderByFechaEventoAsc(viaje.getId()))
                .orElse(List.of());
    }
}
