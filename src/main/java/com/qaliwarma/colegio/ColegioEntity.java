package com.qaliwarma.colegio;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "colegios")
public class ColegioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer colegioId;
    private String nombre;
    private String direccion;
    private String nivelEducativo;
    private String usuario;
    private String password;
    private String rol;
    private String estado = "Activo";
}
