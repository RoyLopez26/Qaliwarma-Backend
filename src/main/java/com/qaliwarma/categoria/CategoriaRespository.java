package com.qaliwarma.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRespository extends JpaRepository<CategoriaEntity, Integer> {

    @Query(value = """
            SELECT * FROM categorias WHERE estado = 'Activo' ORDER BY categoria_id DESC
            """, nativeQuery = true)
    List<CategoriaEntity> listarCategoriasActivas();
}
