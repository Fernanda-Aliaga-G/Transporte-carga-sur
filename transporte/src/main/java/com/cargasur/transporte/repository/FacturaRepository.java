package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    long count();
}
