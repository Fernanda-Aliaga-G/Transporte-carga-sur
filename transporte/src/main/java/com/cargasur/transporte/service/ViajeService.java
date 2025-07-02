package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Viaje;
import com.cargasur.transporte.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public Viaje iniciarViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }
}
