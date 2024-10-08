package test;

import modelo.Cliente;
import modelo.Medidor;
import servicios.GestionClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class GestionClientesTest {

    @Mock
    private Cliente mockCliente;

    @Mock
    private Medidor mockMedidor;

    @InjectMocks
    private GestionClientes gestionClientes;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        gestionClientes = new GestionClientes();
    }

    @Test
    public void testDarDeAltaCliente_nuevoCliente() {
        when(mockCliente.getIdCliente()).thenReturn(1);
        boolean resultado = gestionClientes.darDeAltaCliente(1, "Juan", "Calle Falsa 123", "Residencial", mockMedidor, 25);
        assertTrue(resultado);
        assertEquals(1, gestionClientes.getClientes().size());
    }

    @Test
    public void testDarDeAltaCliente_clienteExistente() {
        gestionClientes.darDeAltaCliente(1, "Juan", "Calle Falsa 123", "Residencial", mockMedidor, 25);
        boolean resultado = gestionClientes.darDeAltaCliente(1, "Juan", "Calle Falsa 123", "Residencial", mockMedidor, 25);
        assertFalse(resultado);
    }

    @Test
    public void testModificarDatosCliente_clienteExistente() {
        gestionClientes.darDeAltaCliente(1, "Juan", "Calle Falsa 123", "Residencial", mockMedidor, 25);
        gestionClientes.modificarDatosCliente(1, "Juan Modificado", "Calle Nueva 456");
        Cliente clienteModificado = gestionClientes.buscarClientePorId(1);
        assertEquals("Juan Modificado", clienteModificado.getNombre());
        assertEquals("Calle Nueva 456", clienteModificado.getDireccion());
    }

    @Test
    public void testDarDeBajaCliente_clienteExistente() {
        gestionClientes.darDeAltaCliente(1, "Juan", "Calle Falsa 123", "Residencial", mockMedidor, 25);
        gestionClientes.darDeBajaCliente(1);
        assertNull(gestionClientes.buscarClientePorId(1));
    }

    @Test
    public void testBuscarClientePorId_clienteInexistente() {
        Cliente cliente = gestionClientes.buscarClientePorId(99);
        assertNull(cliente);
    }

    @Test
    public void testEsMayorDeEdad_clienteMayorDeEdad() {
        when(mockCliente.getEdad()).thenReturn(20);
        assertTrue(gestionClientes.esMayorDeEdad(mockCliente));
    }

    @Test
    public void testEsMayorDeEdad_clienteMenorDeEdad() {
        when(mockCliente.getEdad()).thenReturn(16);
        assertFalse(gestionClientes.esMayorDeEdad(mockCliente));
    }

    @Test
    public void testListarClientesMayoresDeEdad() {
        Cliente cliente1 = mock(Cliente.class);
        Cliente cliente2 = mock(Cliente.class);
        Cliente cliente3 = mock(Cliente.class);

        when(cliente1.getEdad()).thenReturn(20);
        when(cliente2.getEdad()).thenReturn(17);
        when(cliente3.getEdad()).thenReturn(25);

        gestionClientes.setClientes(Arrays.asList(cliente1, cliente2, cliente3));

        List<Cliente> mayoresDeEdad = gestionClientes.listarClientesMayoresDeEdad();
        assertEquals(2, mayoresDeEdad.size());
        assertTrue(mayoresDeEdad.contains(cliente1));
        assertTrue(mayoresDeEdad.contains(cliente3));
    }
}
