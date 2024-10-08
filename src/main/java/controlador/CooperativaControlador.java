package controlador;

import modelo.Cliente;
import modelo.Medidor;
import servicios.GestionClientes;
import servicios.GestionFacturacion;
import servicios.GestionConsumo;

public class CooperativaControlador {
    private GestionClientes gestionClientes;
    private GestionFacturacion gestionFacturacion;
    private GestionConsumo gestionConsumo;

    public CooperativaControlador() {
        this.gestionClientes = new GestionClientes();
        this.gestionFacturacion = new GestionFacturacion();
        this.gestionConsumo = new GestionConsumo();
    }

    public void registrarNuevoCliente(int idCliente, String nombre, String direccion, String tipoCliente, int edad) throws Exception {
        Medidor nuevoMedidor = new Medidor("M" + idCliente);
        gestionClientes.darDeAltaCliente(idCliente, nombre, direccion, tipoCliente, nuevoMedidor, edad);
    }

    public void generarFacturaParaCliente(String idCliente, double nuevaLectura, double tarifa) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            double consumo = gestionConsumo.registrarLectura(cliente, nuevaLectura);
            gestionFacturacion.generarFactura(cliente, consumo, tarifa);
        }
    }

    private Cliente buscarClientePorId(String idCliente) {
        // Implementar la búsqueda en gestionClientes
        return null;
    }

	public GestionClientes getGestionClientes() {
		return gestionClientes;
	}

	public void setGestionClientes(GestionClientes gestionClientes) {
		this.gestionClientes = gestionClientes;
	}

	public GestionFacturacion getGestionFacturacion() {
		return gestionFacturacion;
	}

	public void setGestionFacturacion(GestionFacturacion gestionFacturacion) {
		this.gestionFacturacion = gestionFacturacion;
	}

	public GestionConsumo getGestionConsumo() {
		return gestionConsumo;
	}

	public void setGestionConsumo(GestionConsumo gestionConsumo) {
		this.gestionConsumo = gestionConsumo;
	}

    // Otros métodos para manejar la lógica de la cooperativa
}
