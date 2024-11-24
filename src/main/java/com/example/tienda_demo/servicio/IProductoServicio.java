package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> ListarProductos();

    public Producto GuardarProducto(Producto producto);

    public Producto BuscarProductoPorId(Integer idProducto);

    public void EliminarProducto(Producto producto);
}
