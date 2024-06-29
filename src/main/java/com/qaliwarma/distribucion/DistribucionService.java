package com.qaliwarma.distribucion;

import java.util.List;
import java.util.Map;

public interface DistribucionService {

    DistribucionEntity guardarDistribucion(DistribucionDTO distribucionDTO);

    List<Map<String, Object>> listarDistribucionesConDetalles();

    List<Map<String, Object>> obtenerDistribucionConDetalles(Integer distribucionId);

    String eliminarDistribucion(Integer distribucionId);
}
