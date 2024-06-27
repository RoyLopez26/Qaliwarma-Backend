package com.qaliwarma.categoria;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRespository categoriaRespository;

    public CategoriaServiceImpl(CategoriaRespository categoriaRespository) {
        this.categoriaRespository = categoriaRespository;
    }

    @Override
    public List<CategoriaEntity> listarCategoriasActivas() {
        return categoriaRespository.listarCategoriasActivas();
    }
}
