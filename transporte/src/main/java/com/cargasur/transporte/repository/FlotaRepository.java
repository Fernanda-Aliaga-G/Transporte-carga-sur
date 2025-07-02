package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Flota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface FlotaRepository extends JpaRepository<Flota, Long> {
    List<Flota> findByDisponibleTrueAndEstadoTecnico(String estadoTecnico);
    Optional<Flota> findByPatente(String patente);
    List<Flota> findByFechaProximaMantencionBefore(LocalDate fecha);
}
