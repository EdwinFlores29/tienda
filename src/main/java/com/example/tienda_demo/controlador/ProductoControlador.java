package com.example.tienda_demo.controlador;

import com.example.tienda_demo.excepcion.RecursoNoEncontradoExcepcion;
import com.example.tienda_demo.modelo.Producto;
import com.example.tienda_demo.repositorio.ProductoRepositorio;
import com.example.tienda_demo.servicio.IProductoServicio;
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
@CrossOrigin(value = "http://localhost:3000")
public class ProductoControlador {
    private static final Logger looger =
            LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> ObtenerProductos() {
        var productos = productoServicio.ListarProductos();
        productos.forEach(producto -> looger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos-guardar")
    public Producto agregarProducto(@RequestBody Producto producto) {
        looger.info("producto agregado" + producto);
        return productoServicio.GuardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        Producto producto = productoServicio.BuscarProductoPorId(id);
        if (producto == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el producto con el id " + id));
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoRecibido) {
        Producto producto = productoServicio.BuscarProductoPorId(id);
        if (producto == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el producto con el id " + id));
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setStock(productoRecibido.getStock());
        producto.setEstado(productoRecibido.getEstado());
        producto.setIdCategoria(productoRecibido.getIdCategoria());

        productoServicio.GuardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarProducto(@PathVariable Integer id) {
        Producto producto = productoServicio.BuscarProductoPorId(id);
        if (producto == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el producto con el id " + id));
        productoServicio.EliminarProducto(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
