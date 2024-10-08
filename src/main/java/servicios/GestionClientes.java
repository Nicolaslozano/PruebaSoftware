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
    
    public boolean darDeAltaCliente(int idCliente, String nombre, String direccion, String tipoCliente, Medidor medidor, int edad) {

        
        Cliente nuevoCliente = new Cliente(1, nombre, direccion, tipoCliente, edad);
        clientes.add(nuevoCliente);
        System.out.println("Cliente " + nombre + " dado de alta.");
        return true;
    }

    public void modificarDatosCliente(int idCliente, String nuevoNombre, String nuevaDireccion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente()==idCliente) {
                cliente.setNombre(nuevoNombre);
                cliente.setDireccion(nuevaDireccion);
                System.out.println("Datos del cliente modificados.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void darDeBajaCliente(int idCliente) {
        clientes.removeIf(cliente -> cliente.getIdCliente()==idCliente);
        System.out.println("Cliente dado de baja.");
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Cliente buscarClientePorId(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente()==idCliente) {
                return cliente;
            }
        }
        return null;  // Retorna null si no se encuentra el cliente
    }
	
	public boolean esMayorDeEdad(Cliente cliente) {
	    return cliente.getEdad() >= 18;
	}

}
