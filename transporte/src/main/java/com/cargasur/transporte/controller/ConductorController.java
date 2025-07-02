package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Conductor;
import com.cargasur.transporte.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

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
                .map(conductor -> {
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("id", conductor.getId());
                    datos.put("nombre", conductor.getNombre());
                    datos.put("correo", conductor.getCorreo());
                    return ResponseEntity.ok(datos);
                })
                .orElseGet(() -> ResponseEntity.status(401)
                        .body(Map.of("error", "Credenciales inválidas")));
    }

}
