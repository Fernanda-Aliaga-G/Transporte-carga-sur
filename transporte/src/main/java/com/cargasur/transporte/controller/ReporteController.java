package com.cargasur.transporte.controller;

import com.cargasur.transporte.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/operaciones")
    public ResponseEntity<?> obtenerReporte() {
        return ResponseEntity.ok(reporteService.generarReporteSimple());
    }

}
