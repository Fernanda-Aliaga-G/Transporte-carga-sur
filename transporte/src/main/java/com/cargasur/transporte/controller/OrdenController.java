package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping("/crear")
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        Orden guardada = ordenService.guardarOrden(orden);
        return ResponseEntity.ok(guardada);
    }
    @GetMapping("/{id}/estado")
    public ResponseEntity<String> estadoOrden(@PathVariable Long id) {
        String estado = ordenService.obtenerEstadoOrden(id);
        if (estado.equals("Orden no encontrada")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }

}
