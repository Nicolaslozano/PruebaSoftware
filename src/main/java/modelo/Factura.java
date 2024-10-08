package modelo;

import java.time.LocalDate;

public class Factura {

    private String idFactura;
    private Cliente cliente;
    private LocalDate fechaEmision;
    private double montoTotal;
    private double descuento; // Nuevo atributo para almacenar el descuento

    public Factura(String idFactura, Cliente cliente, double montoTotal) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.fechaEmision = LocalDate.now();
        this.montoTotal = montoTotal;
        this.descuento = 0.0; // Inicializamos el descuento a 0
    }

    // Método para aplicar un descuento
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100");
        }
        this.descuento = porcentaje;
        this.montoTotal -= (this.montoTotal * porcentaje / 100);
    }

    // Método para calcular la fecha de vencimiento de la factura (30 días desde la emisión)
    public LocalDate calcularFechaVencimiento() {
        return this.fechaEmision.plusDays(30);
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getDescuento() {
        return descuento;
    }
}

