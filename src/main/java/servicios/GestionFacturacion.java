package servicios;

import modelo.Cliente;
import modelo.Factura;
import java.util.ArrayList;
import java.util.List;

public class GestionFacturacion {
    private List<Factura> facturas;

    public GestionFacturacion() {
        this.facturas = new ArrayList<>();
    }

    public void generarFactura(Cliente cliente, double consumo, double tarifa) {
        double montoTotal = consumo * tarifa;
        Factura nuevaFactura = new Factura("F" + (facturas.size() + 1), cliente, montoTotal);
        facturas.add(nuevaFactura);
        System.out.println("Factura generada para el cliente: " + cliente.getNombre());
    }

    public void registrarPago(String idFactura) {
        for (Factura factura : facturas) {
            if (factura.getIdFactura().equals(idFactura)) {
                System.out.println("Pago registrado para la factura: " + idFactura);
                return;
            }
        }
        System.out.println("Factura no encontrada.");
    }

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura obtenerUltimaFactura(Cliente cliente) {
        Factura ultimaFactura = null;
        for (Factura factura : facturas) {
            if (factura.getCliente().getIdCliente()==(cliente.getIdCliente())) {
                ultimaFactura = factura;
            }
        }
        return ultimaFactura;  // Devuelve la última factura encontrada o null si no hay facturas
    }
	
}
