package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Entrega;
import com.cargasur.transporte.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrega")
@CrossOrigin(origins = "*")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/confirmar")
    public ResponseEntity<Entrega> confirmar(@RequestBody Entrega entrega) {
        Entrega registrada = entregaService.confirmarEntrega(entrega);
        return ResponseEntity.ok(registrada);
    }
}
