package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.service.EventoService;
import com.cargasur.transporte.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cargasur.transporte.model.Evento;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private OrdenService ordenService;
    @Autowired
    private EventoService eventoService;

    @PostMapping("/crearOrdenWeb")
    public ResponseEntity<Orden> crearOrdenWeb(@RequestBody Orden orden) {
        Orden nuevaOrden = ordenService.crearOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }
    @GetMapping("/seguimiento/{ordenId}")
    public ResponseEntity<List<Evento>> seguimientoOrden(@PathVariable Long ordenId) {
        List<Evento> eventos = eventoService.obtenerEventosPorOrden(ordenId);
        return ResponseEntity.ok(eventos);
    }

}
