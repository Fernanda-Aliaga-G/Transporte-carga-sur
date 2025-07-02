package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Viaje;
import com.cargasur.transporte.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaje")
@CrossOrigin(origins = "*")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @PostMapping("/iniciar")
    public ResponseEntity<Viaje> iniciarViaje(@RequestBody Viaje viaje) {
        Viaje iniciado = viajeService.iniciarViaje(viaje);
        return ResponseEntity.ok(iniciado);
    }
}
