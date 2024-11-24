package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Producto;
import com.example.tienda_demo.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> ListarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto GuardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto BuscarProductoPorId(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void EliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }
}
