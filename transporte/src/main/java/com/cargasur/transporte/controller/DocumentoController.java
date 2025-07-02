package com.cargasur.transporte.controller;

import com.cargasur.transporte.model.Documento;
import com.cargasur.transporte.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/{id}/documentos")
    public ResponseEntity<List<Documento>> obtenerDocumentos(@PathVariable Long id) {
        List<Documento> documentos = documentoService.obtenerDocumentosPorOrden(id);
        return ResponseEntity.ok(documentos);
    }
    @PostMapping("/{id}/subirGuia")
    public ResponseEntity<Documento> subirGuia(@PathVariable Long id, @RequestParam("archivo") String nombreArchivo) {
        Documento doc = documentoService.subirGuia(id, nombreArchivo);
        return ResponseEntity.ok(doc);
    }

}
