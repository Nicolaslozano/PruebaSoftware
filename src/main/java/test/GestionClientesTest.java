package test;

import modelo.Cliente;
import modelo.Medidor;
import servicios.GestionClientes;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestionClientesTest {
/*
    private final GestionClientes gestionClientes = new GestionClientes();
    private final Medidor medidor = new Medidor("M001");

    @Test
    public void testDarDeAltaCliente() throws Exception {
        gestionClientes.darDeAltaCliente(1, "Juan Perez", "Calle Falsa 123", "Residencial", medidor, 18);

        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNotNull("El cliente no debería ser nulo", cliente);
        assertEquals("Juan Perez", cliente.getNombre());
    }

    @Test
    public void testDarDeBajaCliente() throws Exception {
        gestionClientes.darDeAltaCliente(1, "Juan Perez", "Calle Falsa 123", "Residencial", medidor, 18);

        gestionClientes.darDeBajaCliente(1);

        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNull("El cliente debería haber sido eliminado", cliente);
    }

    @Test
    public void testDarDeAltaClienteMenorDeEdad() {
        Exception exception = null;
        try {
            gestionClientes.darDeAltaCliente(1, "Juan Perez", "Calle Falsa 123", "Residencial", medidor, 15);
        } catch (IllegalArgumentException e) {
            exception = e;  // Capturamos la excepción
        }

        assertNotNull("Se esperaba una IllegalArgumentException", exception);
        assertEquals("El cliente debe ser mayor de edad.", exception.getMessage());
    }

 */
}
