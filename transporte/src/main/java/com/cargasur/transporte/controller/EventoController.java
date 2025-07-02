package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Evento;
import com.cargasur.transporte.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaje/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/registrar")
    public ResponseEntity<Evento> registrar(@RequestBody Evento evento) {
        Evento registrado = eventoService.registrarEvento(evento);
        return ResponseEntity.ok(registrado);
    }
    @GetMapping("/{id}/gps")
    public ResponseEntity<String> obtenerUbicacion(@PathVariable Long id) {
        String ubicacion = eventoService.obtenerUbicacionActual(id);
        return ResponseEntity.ok(ubicacion);
    }
    @GetMapping("/cliente/trazabilidad/{ordenId}")
    public ResponseEntity<List<Evento>> trazabilidad(@PathVariable Long ordenId) {
        List<Evento> eventos = eventoService.obtenerEventosPorOrden(ordenId);
        if (eventos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventos);
    }
    @PostMapping("/incidentes")
    public ResponseEntity<Evento> crearAlerta(@RequestBody Evento incidente) {
        incidente.setTipoEvento("INCIDENTE");
        Evento guardado = eventoService.registrarEvento(incidente);
        return ResponseEntity.ok(guardado);
    }
}
