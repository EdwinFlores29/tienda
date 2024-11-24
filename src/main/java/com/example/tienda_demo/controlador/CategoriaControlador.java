package com.example.tienda_demo.controlador;

import com.example.tienda_demo.excepcion.RecursoNoEncontradoExcepcion;
import com.example.tienda_demo.modelo.Categoria;
import com.example.tienda_demo.servicio.ICategoriaServicio;
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
//@CrossOrigin(value = "http://localhost:3000")
public class CategoriaControlador {
    private static final Logger looger =
            LoggerFactory.getLogger(CategoriaControlador.class);

    @Autowired
    private ICategoriaServicio categoriaServicio;
    //en postman usan el metodo get
    @GetMapping("/categorias")
    public List<Categoria> AgregarCategorias(){
        var categorias = categoriaServicio.ListarCategorias();
        categorias.forEach((categoria -> looger.info("Categoria: " + categoria)));
        return categorias;
    }
    //en postman usan el metodo post
    @PostMapping("/categorias-guardar")
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        looger.info("Categoria: " + categoria);
        return categoriaServicio.GuardarCategoria(categoria);
    }
    //en postman usan el metodo get /id, es decir el # del identificador
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable Integer id){
        Categoria categoria = categoriaServicio.BuscarCategoriaPorId(id);
        if(categoria == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el categoria con id: " + id));
        return ResponseEntity.ok(categoria);
    }
    //en postman usan el metodo put /id, es decir el # del identificador para actualizar registro
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaRecibida){
        Categoria categoriaActual = categoriaServicio.BuscarCategoriaPorId(id);
        if (categoriaActual == null)
            throw new RecursoNoEncontradoExcepcion((("No se encontro el categoria con id: " + id)));
        categoriaActual.setDescripcion(categoriaRecibida.getDescripcion());
        categoriaActual.setEstado(categoriaRecibida.getEstado());
        categoriaServicio.GuardarCategoria(categoriaActual);
        return ResponseEntity.ok(categoriaActual);
    }
    //en postman usan el metodo delete /id, es decir el # del identificador para eliminar el registro
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarCategoria(@PathVariable Integer id){
        Categoria categoria = categoriaServicio.BuscarCategoriaPorId(id);
        if (categoria == null)
            throw new RecursoNoEncontradoExcepcion((("No se encontro el categoria con id: " + id)));
        categoriaServicio.EliminarCategoria(categoria);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
