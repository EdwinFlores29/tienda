package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Detalleventa;

import java.util.List;

public interface IDetalleventaServicio {
    public List<Detalleventa> ListarDetalleventas();

    public Detalleventa GuardarDetalleventa(Detalleventa detalleventa);

    public Detalleventa BuscarDetalleventaPorId(Integer idDetalleventa);

    public void EliminarDetalleventa(Detalleventa detalleventa);
}
