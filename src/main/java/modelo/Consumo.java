package modelo;

public class Consumo {

    private Cliente cliente;
    private double consumoTotal;
    private double limiteConsumo; // Límite de consumo mensual

    public Consumo(Cliente cliente, double limiteConsumo) {
        this.cliente = cliente;
        this.consumoTotal = 0;
        this.limiteConsumo = limiteConsumo;
    }

    // Actualiza el consumo sumando el valor recibido
    public void actualizarConsumo(double consumo) {
        if (consumo < 0) {
            throw new IllegalArgumentException("El consumo no puede ser negativo");
        }
        this.consumoTotal += consumo;
    }

    // Aplica un descuento sobre el consumo total
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Porcentaje de descuento inválido");
        }
        double descuento = this.consumoTotal * (porcentaje / 100);
        this.consumoTotal -= descuento;
    }

    // Verifica si el cliente ha alcanzado su límite de consumo
    public boolean haAlcanzadoLimite() {
        return this.consumoTotal >= this.limiteConsumo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getLimiteConsumo() {
        return limiteConsumo;
    }

    public void setLimiteConsumo(double limiteConsumo) {
        this.limiteConsumo = limiteConsumo;
    }
}
