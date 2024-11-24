package com.example.tienda_demo.repositorio;

import com.example.tienda_demo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
