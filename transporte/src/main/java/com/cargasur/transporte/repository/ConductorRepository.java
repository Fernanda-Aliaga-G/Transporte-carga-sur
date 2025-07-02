package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByCorreoAndPassword(String correo, String password);
}
