package com.qaliwarma.empleado;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Map<String, String> loginPlataforma(String usuario, String password) {
        Object usuarioEncontrado = empleadoRepository.loginPlataforma(usuario, password);

        if (usuarioEncontrado != null) {
            Object[] datosUsuario = (Object[]) usuarioEncontrado;
            String nombre = (String) datosUsuario[0];
            String rol = (String) datosUsuario[1];

            return Map.of("nombreUsuario", nombre, "rolUsuario", rol);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
    }
}
