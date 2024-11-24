package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Venta;
import com.example.tienda_demo.repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VentaServicio implements IVentaServicio{
    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public List<Venta> ListarVentas() {
        return ventaRepositorio.findAll();
    }

    @Override
    public Venta GuardarVenta(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    @Override
    public Venta BuscarVentaPorId(Integer idVenta) {
        Venta venta = ventaRepositorio.findById(idVenta).orElse(null);
        return venta;
    }

    @Override
    public void EliminarVenta(Venta venta) {
        ventaRepositorio.delete(venta);
    }
}
