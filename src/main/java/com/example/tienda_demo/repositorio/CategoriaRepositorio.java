package com.example.tienda_demo.repositorio;

import com.example.tienda_demo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
