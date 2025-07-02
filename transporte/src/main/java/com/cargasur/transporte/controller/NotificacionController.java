package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Notificacion;
import com.cargasur.transporte.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/notificar")
    public ResponseEntity<Notificacion> notificar(@RequestBody Notificacion notificacion) {
        Notificacion enviada = notificacionService.enviarNotificacion(notificacion);
        return ResponseEntity.ok(enviada);
    }
}
