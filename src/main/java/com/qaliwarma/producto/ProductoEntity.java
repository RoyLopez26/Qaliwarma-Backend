package com.qaliwarma.producto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    private String nombre;
    private Double cantidad;
    private String unidadMedida;
    private String estado = "Activo";
    private Integer categoriaId;
}
