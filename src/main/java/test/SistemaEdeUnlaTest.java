package test;

import modelo.SistemaEdeUnla;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SistemaEdeUnlaTest {
    private SistemaEdeUnla sistema;

    @Before
    public void setUp() {
        sistema = new SistemaEdeUnla();
    }

    @Test
    public void testAltaClienteFisico() throws Exception{
        assertTrue(sistema.altaClienteFisico(15402030, "San Cristobal", "Pepe", "Pipo", 154030201));
        assertNotNull(sistema.traerClienteFisico(0));
    }

    @Test
    public void testBajaClienteFisico() throws Exception {
        sistema.altaClienteFisico(15402030, "San Cristobal", "Pepe", "Pipo", 154030201);
        assertTrue(sistema.bajaClienteFisico(0));
        assertNull(sistema.traerClienteFisico(0));
    }

    @Test
    public void testModClienteFisico() throws Exception {
        sistema.altaClienteFisico(15402030, "San Cristobal", "Pepe", "Pipo", 154030201);
        sistema.modClienteFisico(0, 15302010, "San Bernardo", "Pipo", "Pepe", 150402010);
    }
}
