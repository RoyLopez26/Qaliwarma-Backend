package com.qaliwarma.proveedor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proveedorId;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String correo;
    private String direccion;
    private String estado = "Activo";
}
