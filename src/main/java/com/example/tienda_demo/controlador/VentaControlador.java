package com.example.tienda_demo.controlador;

import com.example.tienda_demo.excepcion.RecursoNoEncontradoExcepcion;
import com.example.tienda_demo.modelo.Venta;
import com.example.tienda_demo.servicio.IVentaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tienda-app")
public class VentaControlador {
    private static final Logger looger =
            LoggerFactory.getLogger(VentaControlador.class);

    @Autowired
    private IVentaServicio ventaServicio;

    @GetMapping("/ventas")
    public List<Venta> obtenerVentas(){
        var ventas = ventaServicio.ListarVentas();
        ventas.forEach((venta -> looger.info(venta.toString())));
        return ventas;
    }

    @PostMapping("/ventas-guardar")
    public Venta AgregarVenta(@RequestBody Venta venta){
        looger.info("Venta guardada con exito" + venta);
        return ventaServicio.GuardarVenta(venta);
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Integer id){
        Venta venta = ventaServicio.BuscarVentaPorId(id);
        if(venta == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el venta con id: " + id));
        return ResponseEntity.ok(venta);
    }

    @PutMapping("/ventas/{id}")
    public ResponseEntity<Venta> ActualizarVenta(@PathVariable Integer id, @RequestBody Venta ventaRecibido){
        Venta venta = ventaServicio.BuscarVentaPorId(id);
        if (venta == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el venta con id: " + id));
        venta.setFecha_venta(ventaRecibido.getFecha_venta());
        venta.setMonto_total(ventaRecibido.getMonto_total());
        venta.setEstado(ventaRecibido.getEstado());
        venta.setIdCliente(ventaRecibido.getIdCliente());
        ventaServicio.GuardarVenta(venta);
        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarVenta(@PathVariable Integer id) {
        Venta venta = ventaServicio.BuscarVentaPorId(id);
        if (venta == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el venta con id: " + id));
        ventaServicio.EliminarVenta(venta);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
