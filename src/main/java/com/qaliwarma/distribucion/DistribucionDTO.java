package com.qaliwarma.distribucion;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DistribucionDTO {
    private Integer distribucionId;
    private Date fechaDistribucion;
    private String nombreEmpleado;
    private String nombreColegio;
    private String observaciones;
    private String estadoEntrega;
    private List<DetalleDistribucionEntity> detalles;
}
