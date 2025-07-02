package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Flota;
import com.cargasur.transporte.service.FlotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flota")
@CrossOrigin(origins = "*")
public class FlotaController {

    @Autowired
    private FlotaService flotaService;

    @GetMapping("/disponibilidad")
    public ResponseEntity<List<Flota>> obtenerDisponibles() {
        List<Flota> disponibles = flotaService.obtenerFlotaDisponible();
        return ResponseEntity.ok(disponibles);
    }
    @PostMapping("/asignarAutomatica")
    public ResponseEntity<String> asignarFlota(@RequestParam Long ordenId) {
        String resultado = flotaService.asignarAutomatica(ordenId);
        return ResponseEntity.ok(resultado);
    }
    @GetMapping("/mantenimiento/verificarEstado/{patente}")
    public ResponseEntity<String> verificarEstado(@PathVariable String patente) {
        String resultado = flotaService.verificarEstadoTecnico(patente);
        if (resultado.equals("Camión no encontrado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }
    @GetMapping("/mantenimiento/proximos")
    public ResponseEntity<List<Flota>> proximasMantenciones() {
        List<Flota> flotas = flotaService.obtenerMantencionesPendientes();
        return ResponseEntity.ok(flotas);
    }
}
