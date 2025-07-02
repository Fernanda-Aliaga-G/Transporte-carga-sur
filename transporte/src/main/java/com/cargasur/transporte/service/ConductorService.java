package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Conductor;
import com.cargasur.transporte.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public Optional<Conductor> login(String correo, String password) {
        return conductorRepository.findByCorreoAndPassword(correo, password);
    }
}
