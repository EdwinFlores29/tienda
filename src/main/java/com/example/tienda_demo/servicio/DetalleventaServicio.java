package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Detalleventa;
import com.example.tienda_demo.repositorio.DetalleventaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleventaServicio implements IDetalleventaServicio {
    @Autowired
    private DetalleventaRepositorio detalleventaRepositorio;

    @Override
    public List<Detalleventa> ListarDetalleventas() {
        return detalleventaRepositorio.findAll();
    }

    @Override
    public Detalleventa GuardarDetalleventa(Detalleventa detalleventa) {
        return detalleventaRepositorio.save(detalleventa);
    }

    @Override
    public Detalleventa BuscarDetalleventaPorId(Integer idDetalleventa) {
        Detalleventa detalleventa = detalleventaRepositorio.findById(idDetalleventa).orElse(null);
        return detalleventa;
    }

    @Override
    public void EliminarDetalleventa(Detalleventa detalleventa) {
        detalleventaRepositorio.delete(detalleventa);
    }
}
