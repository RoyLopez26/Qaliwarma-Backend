package com.qaliwarma.distribucion;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DistribucionServiceImpl implements DistribucionService{

    private final DistribucionRepository distribucionRepository;
    private final DetalleDistribucionRepository detalleDistribucionRepository;

    public DistribucionServiceImpl(DistribucionRepository distribucionRepository, DetalleDistribucionRepository detalleDistribucionRepository) {
        this.distribucionRepository = distribucionRepository;
        this.detalleDistribucionRepository = detalleDistribucionRepository;
    }

    @Override
    public DistribucionEntity guardarDistribucion(DistribucionDTO distribucionDTO) {

        DistribucionEntity distribucionEntity = new DistribucionEntity();
        distribucionEntity.setFechaDistribucion(distribucionDTO.getFechaDistribucion());
        distribucionEntity.setNombreEmpleado(distribucionDTO.getNombreEmpleado());
        distribucionEntity.setNombreColegio(distribucionDTO.getNombreColegio());
        distribucionEntity.setObservaciones(distribucionDTO.getObservaciones());
        distribucionEntity.setEstadoEntrega(distribucionDTO.getEstadoEntrega());
        distribucionEntity.setEstado("Activo");

        distribucionEntity = distribucionRepository.save(distribucionEntity);

        List<DetalleDistribucionEntity> detalles = distribucionDTO.getDetalles();
        for (DetalleDistribucionEntity detalle : detalles) {
            detalle.setDistribucionId(distribucionEntity.getDistribucionId());
            detalleDistribucionRepository.save(detalle);
        }
        return distribucionEntity;
    }

    @Override
    public List<Map<String, Object>> listarDistribucionesConDetalles() {
        List<Object[]> resultadoConsulta = distribucionRepository.listarDistribucionesConDetalles();
        return agruparDetallesPorDistribucion(resultadoConsulta);
    }

    @Override
    public List<Map<String, Object>> obtenerDistribucionConDetalles(Integer distribucionId) {
        List<Object[]> resultadoConsulta = distribucionRepository.obtenerDistribucionConDetalles(distribucionId);
        return agruparDetallesPorDistribucion(resultadoConsulta);
    }

    @Override
    public String eliminarDistribucion(Integer distribucionId) {
        var distribucion = distribucionRepository.findById(distribucionId).orElse(null);
        distribucion.setEstado("Inactivo");
        distribucionRepository.save(distribucion);
        return "Distribucion eliminada correctamente";
    }

    @Override
    public String actualizarEstado(Integer distribucionId) {
        var distribucion = distribucionRepository.findById(distribucionId).orElse(null);
        distribucion.setEstadoEntrega("Completado");
        distribucionRepository.save(distribucion);
        return "Se cambio el estado correctamente";
    }

    private List<Map<String, Object>> agruparDetallesPorDistribucion(List<Object[]> resultadoConsulta) {
        Map<Integer, Map<String, Object>> distribucionesMap = new LinkedHashMap<>();

        for (Object[] fila : resultadoConsulta) {
            Integer distribucionId = (Integer) fila[0];

            // Crear mapa para el detalle
            Map<String, Object> detalle = new LinkedHashMap<>();
            detalle.put("nombreProducto", fila[6]);
            detalle.put("cantidad", fila[7]);
            detalle.put("unidadMedida", fila[8]);

            // Obtener o crear la distribución del mapa
            Map<String, Object> distribucion = distribucionesMap.computeIfAbsent(distribucionId, k -> {
                Map<String, Object> nuevaDistribucion = new LinkedHashMap<>();
                nuevaDistribucion.put("distribucionId", fila[0]);
                nuevaDistribucion.put("fechaDistribucion", fila[1]);
                nuevaDistribucion.put("nombreColegio", fila[2]);
                nuevaDistribucion.put("nombreEmpleado", fila[3]);
                nuevaDistribucion.put("observaciones", fila[4]);
                nuevaDistribucion.put("estadoEntrega", fila[5]);
                nuevaDistribucion.put("detalles", new ArrayList<>());
                return nuevaDistribucion;
            });

            // Agregar el detalle a la lista de detalles de la distribución
            ((List<Map<String, Object>>) distribucion.get("detalles")).add(detalle);
        }

        return new ArrayList<>(distribucionesMap.values());
    }
}
