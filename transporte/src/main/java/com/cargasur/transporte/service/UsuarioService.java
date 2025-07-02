package com.cargasur.transporte.service;

import com.cargasur.transporte.model.Usuario;
import com.cargasur.transporte.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<String> obtenerRolPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo)
                .map(Usuario::getRol);
    }
}
