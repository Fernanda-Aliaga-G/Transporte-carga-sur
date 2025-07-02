package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    Optional<Viaje> findByOrdenId(Long ordenId);
}
