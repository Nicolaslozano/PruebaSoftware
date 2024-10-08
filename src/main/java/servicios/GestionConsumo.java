package servicios;

import modelo.Cliente;
import modelo.Medidor;

public class GestionConsumo {

    public double registrarLectura(Cliente cliente, double nuevaLectura) {

        Medidor medidor = cliente.getMedidor();
        medidor.registrarLectura(nuevaLectura);
        double consumo = medidor.calcularConsumo();
        System.out.println("Lectura registrada para el cliente: " + cliente.getNombre() + ". Consumo: " + consumo + " kWh.");
        return consumo;
    }



        // Otros métodos para manejar alertas de consumo
    }

