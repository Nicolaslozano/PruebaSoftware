package test;

import modelo.Cliente;
import modelo.Consumo;
import servicios.GestionClientes;
import modelo.Medidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GestionClientesIntegrationTest {

    private GestionClientes gestionClientes;

    @BeforeEach
    public void setUp() {
        gestionClientes = new GestionClientes();
    }

    // 1. Test para dar de alta un cliente y verificar su existencia
    @Test
    public void testDarDeAltaCliente() {
        boolean resultado = gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        assertTrue(resultado);
        
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNotNull(cliente);
        assertEquals("Juan Pérez", cliente.getNombre());
    }

    // 2. Test para evitar dar de alta un cliente existente
    @Test
    public void testDarDeAltaClienteExistente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        boolean resultado = gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        assertFalse(resultado);
    }

    // 3. Test para modificar los datos de un cliente existente
    @Test
    public void testModificarDatosCliente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        gestionClientes.modificarDatosCliente(1, "Juan Carlos Pérez", "Calle Falsa 456");
        
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNotNull(cliente);
        assertEquals("Juan Carlos Pérez", cliente.getNombre());
        assertEquals("Calle Falsa 456", cliente.getDireccion());
    }

    // 4. Test para dar de baja un cliente
    @Test
    public void testDarDeBajaCliente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        gestionClientes.darDeBajaCliente(1);
        
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNull(cliente);
    }

    // 5. Test para listar clientes mayores de edad
    @Test
    public void testListarClientesMayoresDeEdad() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        gestionClientes.darDeAltaCliente(2, "Ana Gómez", "Calle Verdadera 789", "Comercial", null, 17);
        
        List<Cliente> mayoresDeEdad = gestionClientes.listarClientesMayoresDeEdad();
        assertEquals(1, mayoresDeEdad.size());
        assertEquals("Juan Pérez", mayoresDeEdad.get(0).getNombre());
    }

    // 6. Test para verificar la creación de un Consumo asociado al cliente
    @Test
    public void testCrearConsumoAlDarDeAltaCliente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        
        assertNotNull(cliente.getConsumo());
        assertEquals(0, cliente.getConsumo().getConsumoTotal());
    }

    // 7. Test para actualizar el consumo de un cliente
    @Test
    public void testActualizarConsumoCliente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        
        Consumo consumo = new Consumo(cliente, 500); // Límite de consumo inicial
        cliente.setConsumo(consumo); // Asignar consumo al cliente

        consumo.actualizarConsumo(200);
        assertEquals(200, consumo.getConsumoTotal(), 0.01);
    }


    // 8. Test para aplicar un descuento en el consumo
    @Test
    public void testAplicarDescuentoEnConsumo() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        
        Consumo consumo = new Consumo(cliente, 500); // Límite de consumo inicial
        cliente.setConsumo(consumo); // Asigna consumo al cliente

        consumo.actualizarConsumo(400);
        consumo.aplicarDescuento(25);

        assertEquals(300, consumo.getConsumoTotal(), 0.01);
    }


    // 9. Test para verificar si el cliente ha alcanzado el límite de consumo
    @Test
    public void testAlcanzarLimiteConsumo() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        Cliente cliente = gestionClientes.buscarClientePorId(1);

        // Aseguramos que el cliente tenga un objeto Consumo asociado
        Consumo consumo = new Consumo(cliente, 500); // Establecemos el límite
        cliente.setConsumo(consumo);

        // Actualizamos el consumo para alcanzar el límite
        consumo.actualizarConsumo(500);

        assertTrue(consumo.haAlcanzadoLimite());
    }


    // 10. Test para verificar que un cliente no puede ser dado de baja si no existe
    @Test
    public void testDarDeBajaClienteInexistente() {
        gestionClientes.darDeAltaCliente(1, "Juan Pérez", "Calle Falsa 123", "Residencial", null, 25);
        gestionClientes.darDeBajaCliente(2); // Cliente inexistente
        
        Cliente cliente = gestionClientes.buscarClientePorId(1);
        assertNotNull(cliente); // Juan Pérez aún debe existir
    }
}
