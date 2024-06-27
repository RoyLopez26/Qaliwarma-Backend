package com.qaliwarma.empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

    @Query(value = """
            SELECT nombres, rol
            FROM empleados
            WHERE usuario = :usuario
              AND password = :password
            UNION
            SELECT nombre, rol
            FROM colegios
            WHERE usuario = :usuario
              AND password = :password;
            """, nativeQuery = true)
    Object loginPlataforma(@Param("usuario") String usuario,
                           @Param("password") String password);
}
