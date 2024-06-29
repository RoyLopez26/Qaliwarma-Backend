package com.qaliwarma.distribucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistribucionRepository extends JpaRepository<DistribucionEntity, Integer> {

    @Query(value = "SELECT d.distribucion_id, " +
            "d.fecha_distribucion, " +
            "d.nombre_colegio, " +
            "d.nombre_empleado, " +
            "d.observaciones, " +
            "d.estado_entrega, " +
            "dd.nombre_producto, " +
            "dd.cantidad, " +
            "dd.unidad_medida " +
            "FROM distribuciones d " +
            "LEFT JOIN detalles_distribuciones dd ON d.distribucion_id = dd.distribucion_id " +
            "WHERE d.distribucion_id = :distribucionId AND d.estado = 'Activo'", nativeQuery = true)
    List<Object[]> obtenerDistribucionConDetalles(Integer distribucionId);

    @Query(value = "SELECT d.distribucion_id, " +
            "d.fecha_distribucion, " +
            "d.nombre_colegio, " +
            "d.nombre_empleado, " +
            "d.observaciones, " +
            "d.estado_entrega, " +
            "dd.nombre_producto, " +
            "dd.cantidad, " +
            "dd.unidad_medida " +
            "FROM distribuciones d " +
            "LEFT JOIN detalles_distribuciones dd ON d.distribucion_id = dd.distribucion_id " +
            "WHERE d.estado = 'Activo'", nativeQuery = true)
    List<Object[]> listarDistribucionesConDetalles();
}
