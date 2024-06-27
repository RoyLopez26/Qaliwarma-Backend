package com.qaliwarma.empleado;

import com.qaliwarma.utils.CredencialesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CredencialesDTO credencialesDTO) {
        try {
            Map<String, String> datosUsuario = empleadoService.loginPlataforma(credencialesDTO.getUsuario(), credencialesDTO.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(datosUsuario);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}
