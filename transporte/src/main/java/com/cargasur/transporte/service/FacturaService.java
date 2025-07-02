package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Factura;
import com.cargasur.transporte.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura emitirFactura(Long ordenId) {
        Factura factura = new Factura();
        factura.setOrdenId(ordenId);
        factura.setFechaEmision(LocalDateTime.now());
        factura.setMontoTotal(50000.0);
        factura.setNumeroFactura("FAC-" + String.format("%04d", facturaRepository.count() + 1));

        return facturaRepository.save(factura);
    }
}
