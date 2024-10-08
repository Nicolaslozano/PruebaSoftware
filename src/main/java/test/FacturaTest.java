package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import modelo.Cliente;
import modelo.Factura;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FacturaTest {

    @Mock
    private Cliente mockCliente;

    @InjectMocks
    private Factura factura;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        factura = new Factura("F001", mockCliente, 1000.0);
    }

    @Test
    public void testAplicarDescuento_valido() {
        factura.aplicarDescuento(10); // Aplicar 10% de descuento
        assertEquals(900.0, factura.getMontoTotal(), 0.01);
        assertEquals(10, factura.getDescuento(), 0.01);
    }

    @Test
    public void testAplicarDescuento_invalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factura.aplicarDescuento(150); // Descuento inválido
        });
        assertEquals("El porcentaje de descuento debe estar entre 0 y 100", exception.getMessage());
    }

    @Test
    public void testCalcularFechaVencimiento() {
        LocalDate fechaEsperada = factura.getFechaEmision().plusDays(30);
        assertEquals(fechaEsperada, factura.calcularFechaVencimiento());
    }

    @Test
    public void testGetCliente() {
        when(mockCliente.getNombre()).thenReturn("Cliente de Prueba");
        assertEquals("Cliente de Prueba", factura.getCliente().getNombre());
    }

    @Test
    public void testModificarMontoTotal() {
        factura.setMontoTotal(2000.0);
        assertEquals(2000.0, factura.getMontoTotal(), 0.01);
    }

    @Test
    public void testModificarIdFactura() {
        factura.setIdFactura("F002");
        assertEquals("F002", factura.getIdFactura());
    }
}
