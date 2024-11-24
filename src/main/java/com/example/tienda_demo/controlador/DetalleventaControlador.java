package com.example.tienda_demo.controlador;

import com.example.tienda_demo.excepcion.RecursoNoEncontradoExcepcion;
import com.example.tienda_demo.modelo.Detalleventa;
import com.example.tienda_demo.servicio.IDetalleventaServicio;
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
public class DetalleventaControlador {
    private static final Logger looger =
            LoggerFactory.getLogger(DetalleventaControlador.class);

    @Autowired
    private IDetalleventaServicio detalleventaServicio;

    @GetMapping("/detalleventas")
    public List<Detalleventa> Obtnerdetalleventas(){
        var detalleventas = detalleventaServicio.ListarDetalleventas();
        detalleventas.forEach((detalleventa -> looger.info(detalleventa.toString())));
        return detalleventas;
    }

    @PostMapping("/detalleventas-agregar")
    public Detalleventa AgregarDetalleventa(@RequestBody Detalleventa detalleventa) {
        looger.info("Detalleventa agregada" + detalleventa);
        return detalleventaServicio.GuardarDetalleventa(detalleventa);
    }

    @GetMapping("/detalleventas/{id}")
    public ResponseEntity<Detalleventa> ObtenerDetalleventa(@PathVariable Integer id) {
        Detalleventa detalleventa = detalleventaServicio.BuscarDetalleventaPorId(id);
        if (detalleventa == null)
            throw new RecursoNoEncontradoExcepcion(("Detalleventa no encontrado" + id));
        return ResponseEntity.ok(detalleventa);
    }

    @PutMapping("/detalleventas/{id}")
    public ResponseEntity<Detalleventa> actualizarDetalleventa(@PathVariable Integer id, @RequestBody Detalleventa detalleventaRecibida) {
        Detalleventa detalleventa = detalleventaServicio.BuscarDetalleventaPorId(id);
        if (detalleventa == null)
            throw new RecursoNoEncontradoExcepcion(("Detalleventa no encontrado" + id));
        detalleventa.setCantidad(detalleventaRecibida.getCantidad());
        detalleventa.setPrecio_unitario(detalleventaRecibida.getPrecio_unitario());
        detalleventa.setMonto_detalleventa(detalleventaRecibida.getMonto_detalleventa());
        detalleventa.setEstado(detalleventaRecibida.getEstado());
        detalleventa.setIdProducto(detalleventaRecibida.getIdProducto());
        detalleventa.setIdVenta(detalleventaRecibida.getIdVenta());
        detalleventaServicio.GuardarDetalleventa(detalleventa);
        return ResponseEntity.ok(detalleventa);
    }

    @DeleteMapping("/detalleventas/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarDetalleventa(@PathVariable Integer id) {
        Detalleventa detalleventa = detalleventaServicio.BuscarDetalleventaPorId(id);
        if (detalleventa == null)
            throw new RecursoNoEncontradoExcepcion(("Detalleventa no encontrado" + id));
        detalleventaServicio.EliminarDetalleventa(detalleventa);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
