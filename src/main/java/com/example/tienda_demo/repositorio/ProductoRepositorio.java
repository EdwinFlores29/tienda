package com.example.tienda_demo.repositorio;

import com.example.tienda_demo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
