package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Conductor;
import com.cargasur.transporte.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/conductor")
@CrossOrigin(origins = "*")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String correo = loginData.get("correo");
        String password = loginData.get("password");

        return conductorService.login(correo, password)
                .map(conductor -> ResponseEntity.ok(Map.of(
                        "id", conductor.getId(),
                        "nombre", conductor.getNombre(),
                        "correo", conductor.getCorreo()
                )))
                .orElse(ResponseEntity.status(401).body("Credenciales inválidas"));
    }
}
