package com.example.tienda_demo.controlador;

import com.example.tienda_demo.excepcion.RecursoNoEncontradoExcepcion;
import com.example.tienda_demo.modelo.Cliente;
import com.example.tienda_demo.servicio.IClienteServicio;
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
public class ClienteControlador {
    private static final Logger looger =
            LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> Obtenerclientes(){
        var clientes = clienteServicio.ListarClientes();
        clientes.forEach((cliente -> looger.info(cliente.toString())));
        return clientes;
    }

    @PostMapping("/clientes-guardar")
    public Cliente AgregarCliente(@RequestBody Cliente cliente){
        looger.info("cliente guardado" + cliente.toString());
        return clienteServicio.GuardarCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> ObtenerCliente(@PathVariable Integer id){
        Cliente cliente = clienteServicio.BuscarClientePorId(id);
        if (cliente == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el cliente con el id: " + id));
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente clienteRecibido, @PathVariable Integer id){
        Cliente cliente = clienteServicio.BuscarClientePorId(id);
        if (cliente == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el cliente con el id: " + id));
        cliente.setNombre(clienteRecibido.getNombre());
        cliente.setApellido(clienteRecibido.getApellido());
        cliente.setNro_documento(clienteRecibido.getNro_documento());
        cliente.setEstado(clienteRecibido.getEstado());
        clienteServicio.GuardarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteServicio.BuscarClientePorId(id);
        if (cliente == null)
            throw new RecursoNoEncontradoExcepcion(("No se encontro el cliente con el id: " + id));
        clienteServicio.EliminarCliente(cliente);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
