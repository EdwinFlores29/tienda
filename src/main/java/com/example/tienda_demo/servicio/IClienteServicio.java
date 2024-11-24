package com.example.tienda_demo.servicio;

import com.example.tienda_demo.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> ListarClientes();

    public Cliente GuardarCliente(Cliente cliente);

    public Cliente BuscarClientePorId(Integer idCliente);

    public void EliminarCliente(Cliente cliente);
}
