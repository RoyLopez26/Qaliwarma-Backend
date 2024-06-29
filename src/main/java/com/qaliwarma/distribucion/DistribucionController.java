package com.qaliwarma.distribucion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/distribucion")
public class DistribucionController {

    private final DistribucionService distribucionService;

    public DistribucionController(DistribucionService distribucionService) {
        this.distribucionService = distribucionService;
    }

    @PostMapping
    public ResponseEntity<?> guardarDistribucion(@RequestBody DistribucionDTO distribucionDTO) {
        DistribucionEntity distribucionGuardada = distribucionService.guardarDistribucion(distribucionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(distribucionGuardada);
    }

    @GetMapping
    public ResponseEntity<?> listarDistribucionesConDetalles() {
        List<Map<String, Object>> distribuciones = distribucionService.listarDistribucionesConDetalles();
        return ResponseEntity.ok(distribuciones);
    }

    @GetMapping("/{distribucionId}")
    public ResponseEntity<?> obtenerDistribucionConDetalles(@PathVariable Integer distribucionId) {
        List<Map<String, Object>> distribucion = distribucionService.obtenerDistribucionConDetalles(distribucionId);
        if (distribucion != null && !distribucion.isEmpty()) {
            return ResponseEntity.ok(distribucion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{distribucionId}")
    public ResponseEntity<?> eliminarDistribucion(@PathVariable Integer distribucionId) {
        var mensaje = distribucionService.eliminarDistribucion(distribucionId);
        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    }

}
