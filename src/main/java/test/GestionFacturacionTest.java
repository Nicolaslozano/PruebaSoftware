package test;

import modelo.Cliente;
import modelo.Factura;
import modelo.Medidor;
import servicios.GestionFacturacion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GestionFacturacionTest {

    @Test
    public void testGenerarFactura() {
        /*
        GestionFacturacion gestionFacturacion = new GestionFacturacion();
        Medidor medidor = new Medidor("M001");
        Cliente cliente = new Cliente(1, "Juan Perez", "Calle Falsa 123", "Residencial", medidor, 18);

        gestionFacturacion.generarFactura(cliente, 100, 0.5);  // Consumo: 100 kWh, tarifa: 0.5 por kWh

        Factura factura = gestionFacturacion.obtenerUltimaFactura(cliente);
        assertNotNull("La factura no debería ser nula", factura);

        // Utiliza un delta para comparar números de punto flotante
        double expectedMonto = 50.0;
        double actualMonto = factura.getMontoTotal();
        double delta = 0.01; // Un pequeño margen de error
        assertEquals("El monto total de la factura no es el esperado", expectedMonto, actualMonto, delta);
    }

         */
    }
}
