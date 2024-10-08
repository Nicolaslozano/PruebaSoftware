package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Medidor;

import static org.junit.jupiter.api.Assertions.*;

public class MedidorTest {

    private Medidor medidor;

    @BeforeEach
    public void setup() {
        medidor = new Medidor("M001");
        medidor.setLimiteConsumoDiario(100); // Límite para facilitar pruebas
    }

    @Test
    public void testRegistrarLectura_valida() {
        medidor.registrarLectura(150);
        assertEquals(150, medidor.getLecturaActual());
        assertEquals(0, medidor.getLecturaAnterior());
    }

    @Test
    public void testRegistrarLectura_negativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            medidor.registrarLectura(-10); // Valor negativo
        });
        assertEquals("La lectura no puede ser negativa", exception.getMessage());
    }

    @Test
    public void testCalcularConsumo() {
        medidor.registrarLectura(100);
        medidor.registrarLectura(200);
        assertEquals(100, medidor.calcularConsumo(), 0.01);
    }

    @Test
    public void testExcedeLimiteDiario_noExcede() {
        medidor.registrarLectura(50); // Consumo total de 50, por debajo del límite
        medidor.registrarLectura(90); // Consumo adicional de 40
        assertFalse(medidor.excedeLimiteDiario());
    }

    @Test
    public void testExcedeLimiteDiario_excede() {
        medidor.registrarLectura(0);
        medidor.registrarLectura(150); // Incremento de 150, sobrepasa el límite
        assertTrue(medidor.excedeLimiteDiario());
    }

    @Test
    public void testResetearLecturas() {
        medidor.registrarLectura(300);
        medidor.resetearLecturas();
        assertEquals(0, medidor.getLecturaActual());
        assertEquals(0, medidor.getLecturaAnterior());
    }

    @Test
    public void testModificarLimiteConsumoDiario() {
        medidor.setLimiteConsumoDiario(500);
        assertEquals(500, medidor.getLimiteConsumoDiario());
    }
}

