package com.qaliwarma.distribucion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "distribuciones")
public class DistribucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer distribucionId;
    private Date fechaDistribucion;
    private String nombreEmpleado;
    private String nombreColegio;
    private String observaciones;
    private String estadoEntrega;
    @JsonIgnore
    private String estado;
}
