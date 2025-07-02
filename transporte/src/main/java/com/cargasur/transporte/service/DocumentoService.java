package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Documento;
import com.cargasur.transporte.model.Orden;
import com.cargasur.transporte.repository.DocumentoRepository;
import com.cargasur.transporte.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Documento> obtenerDocumentosPorOrden(Long ordenId) {
        return documentoRepository.findByOrdenId(ordenId);
    }
    public Documento subirGuia(Long ordenId, String nombreArchivo) {
        Orden orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Documento doc = new Documento();
        doc.setNombre(nombreArchivo);
        doc.setUrl("/documentos/" + nombreArchivo);
        doc.setOrden(orden);

        return documentoRepository.save(doc);
    }
}
