package com.example.tienda_demo.repositorio;

import com.example.tienda_demo.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
}
