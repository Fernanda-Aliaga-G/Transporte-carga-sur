package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByViajeIdOrderByFechaEventoDesc(Long viajeId);
    List<Evento> findByViajeIdOrderByFechaEventoAsc(Long viajeId);
}
