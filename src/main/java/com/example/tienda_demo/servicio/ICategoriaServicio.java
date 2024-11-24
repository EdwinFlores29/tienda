package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio {

    public List<Categoria> ListarCategorias();

    public Categoria GuardarCategoria(Categoria categoria);

    public Categoria BuscarCategoriaPorId(Integer idCategoria);

    public void EliminarCategoria(Categoria categoria);

}
