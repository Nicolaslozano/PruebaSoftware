package test;

import org.junit.Before;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import modelo.Cliente;
import modelo.Medidor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClienteTest {

    @Mock
    private Cliente mockCliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Inicializa los mocks
    }

    @Test
    public void crearClienteMismoID() {
        when(mockCliente.getIdCliente()).thenReturn(1); // Configura el ID para esta prueba
        Cliente cliente2 = new Cliente(1, "Pepe Perez", "Calle Malta 132", "Residencial", 0);
        assertNotEquals("Ya existe un cliente con esa id", cliente2.getIdCliente(), mockCliente.getIdCliente());
    }

    @Test
    public void direccionInvalida() {
        when(mockCliente.getDireccion()).thenReturn("");
        mockCliente.setDireccion("");
    }

    @Test
    public void tipoClienteValido() {
        String tipoValido = "Comercial";
        mockCliente.setTipoCliente(tipoValido); // Establecemos un tipo de cliente válido
        when(mockCliente.getTipoCliente()).thenReturn(tipoValido); // Configuramos el stub
        assertEquals("El tipo de cliente debe ser 'Comercial'", tipoValido, mockCliente.getTipoCliente());
    }

    @Test
    public void edadNoValida() {
        when(mockCliente.getEdad()).thenReturn(2); // Configura una edad no válida para esta prueba
        assertTrue("La edad debe ser mayor a 18 años", mockCliente.getEdad() >= 18);
    }

    @Test
    public void nombreClienteVacio() {
        when(mockCliente.getNombre()).thenReturn(""); // Configura el nombre vacío para esta prueba
        assertNotEquals("El nombre del cliente no debe estar vacío", "", mockCliente.getNombre());
    }


}