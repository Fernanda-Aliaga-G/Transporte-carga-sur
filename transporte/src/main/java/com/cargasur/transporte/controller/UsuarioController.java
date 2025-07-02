package com.cargasur.transporte.controller;

import com.cargasur.transporte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/rol")
    public ResponseEntity<?> obtenerRol(@RequestParam String correo) {
        return usuarioService.obtenerRolPorCorreo(correo)
                .<ResponseEntity<?>>map(rol -> ResponseEntity.ok(Map.of("rol", rol)))
                .orElse(ResponseEntity.status(404).body("Usuario no encontrado"));
    }


}
