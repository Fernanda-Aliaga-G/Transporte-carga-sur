package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Factura;
import com.cargasur.transporte.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturacion")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/emitirFactura")
    public ResponseEntity<Factura> emitir(@RequestParam Long ordenId) {
        Factura factura = facturaService.emitirFactura(ordenId);
        return ResponseEntity.ok(factura);
    }
}
