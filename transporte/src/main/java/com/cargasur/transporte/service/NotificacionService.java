package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Notificacion;
import com.cargasur.transporte.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion enviarNotificacion(Notificacion notificacion) {
        notificacion.setFechaEnvio(LocalDateTime.now());
        return notificacionRepository.save(notificacion);
    }
}
