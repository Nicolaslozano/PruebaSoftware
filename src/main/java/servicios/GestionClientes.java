package servicios;

import modelo.Cliente;

import modelo.Medidor;

import java.util.ArrayList;
import java.util.List;

public class GestionClientes {

    private List<Cliente> clientes;

    public GestionClientes() {
        this.clientes = new ArrayList<>();
    }

    // Verifica si el cliente ya existe antes de agregarlo
    public boolean darDeAltaCliente(int idCliente, String nombre, String direccion, String tipoCliente, Medidor medidor, int edad) {
        if (buscarClientePorId(idCliente) != null) {
            System.out.println("El cliente ya existe.");
            return false;
        }
        Cliente nuevoCliente = new Cliente(idCliente, nombre, direccion, tipoCliente, edad);
        clientes.add(nuevoCliente);
        System.out.println("Cliente " + nombre + " dado de alta.");
        return true;
    }

    public void modificarDatosCliente(int idCliente, String nuevoNombre, String nuevaDireccion) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            cliente.setNombre(nuevoNombre);
            cliente.setDireccion(nuevaDireccion);
            System.out.println("Datos del cliente modificados.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void darDeBajaCliente(int idCliente) {
        boolean eliminado = clientes.removeIf(cliente -> cliente.getIdCliente() == idCliente);
        if (eliminado) {
            System.out.println("Cliente dado de baja.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente buscarClientePorId(int idCliente) {
        return clientes.stream()
                       .filter(cliente -> cliente.getIdCliente() == idCliente)
                       .findFirst()
                       .orElse(null);
    }

    public boolean esMayorDeEdad(Cliente cliente) {
        return cliente.getEdad() >= 18;
    }

    // Nuevo método para obtener todos los clientes mayores de edad
    public List<Cliente> listarClientesMayoresDeEdad() {
        List<Cliente> mayoresDeEdad = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (esMayorDeEdad(cliente)) {
                mayoresDeEdad.add(cliente);
            }
        }
        return mayoresDeEdad;
    }

    // Getters y Setters
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}