package com.example.tienda_demo.repositorio;

import com.example.tienda_demo.modelo.Detalleventa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleventaRepositorio extends JpaRepository<Detalleventa, Integer> {
}
