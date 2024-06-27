package com.qaliwarma.empleado;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empleados")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empleadoId;
    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String correo;
    private String usuario;
    private String password;
    private String rol;
    private String estado = "Activo";
}
