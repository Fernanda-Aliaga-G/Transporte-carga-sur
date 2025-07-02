package com.cargasur.transporte.repository;

import com.cargasur.transporte.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByOrdenId(Long ordenId);
}
