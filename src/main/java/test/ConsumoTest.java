package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import modelo.Cliente;
import modelo.Consumo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsumoTest {

    @Mock
    private Cliente mockCliente;

    @InjectMocks
    private Consumo consumo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        consumo = new Consumo(mockCliente, 500); // Establecemos un límite de consumo de 500
    }

    @Test
    public void testActualizarConsumo_valido() {
        consumo.actualizarConsumo(100); // Agregamos 100 al consumo
        assertEquals(100, consumo.getConsumoTotal(), 0.01);
    }

    @Test
    public void testActualizarConsumo_negativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consumo.actualizarConsumo(-50); // Valor negativo
        });
        assertEquals("El consumo no puede ser negativo", exception.getMessage());
    }

    @Test
    public void testAplicarDescuento_valido() {
        consumo.actualizarConsumo(200);
        consumo.aplicarDescuento(10); // Aplica un 10% de descuento
        assertEquals(180, consumo.getConsumoTotal(), 0.01);
    }

    @Test
    public void testAplicarDescuento_invalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consumo.aplicarDescuento(110); // Porcentaje inválido
        });
        assertEquals("Porcentaje de descuento inválido", exception.getMessage());
    }

    @Test
    public void testHaAlcanzadoLimite_noAlcanzado() {
        consumo.actualizarConsumo(300); // No alcanza el límite de 500
        assertFalse(consumo.haAlcanzadoLimite());
    }

    @Test
    public void testHaAlcanzadoLimite_alcanzado() {
        consumo.actualizarConsumo(600); // Supera el límite de 500
        assertTrue(consumo.haAlcanzadoLimite());
    }

    @Test
    public void testModificarLimiteConsumo() {
        consumo.setLimiteConsumo(1000);
        assertEquals(1000, consumo.getLimiteConsumo());
    }

    @Test
    public void testGetCliente() {
        when(mockCliente.getNombre()).thenReturn("Cliente de Ejemplo");
        assertEquals("Cliente de Ejemplo", consumo.getCliente().getNombre());
    }
}