package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Cliente;
import com.example.tienda_demo.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> ListarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente GuardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente BuscarClientePorId(Integer idCliente) {
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void EliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }

}
