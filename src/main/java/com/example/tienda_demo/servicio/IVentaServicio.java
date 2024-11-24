package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Venta;

import java.util.List;

public interface IVentaServicio {
    public List<Venta> ListarVentas();

    public Venta GuardarVenta(Venta venta);

    public Venta BuscarVentaPorId(Integer idVenta);

    public void EliminarVenta(Venta venta);
}
