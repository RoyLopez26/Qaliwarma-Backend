package com.qaliwarma.distribucion;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalles_distribuciones")
public class DetalleDistribucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleDistribucionId;
    private String nombreProducto;
    private String cantidad;
    private String unidadMedida;
    private Integer distribucionId;
}
