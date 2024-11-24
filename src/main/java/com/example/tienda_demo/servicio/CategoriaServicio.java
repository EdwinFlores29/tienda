package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Categoria;
import com.example.tienda_demo.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServicio implements ICategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> ListarCategorias() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria GuardarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public Categoria BuscarCategoriaPorId(Integer idCategoria) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria).orElse(null);
        return categoria;
    }

    @Override
    public void EliminarCategoria(Categoria categoria) {
        categoriaRepositorio.delete(categoria);
    }
}
