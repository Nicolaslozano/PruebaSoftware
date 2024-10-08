package modelo;

import java.time.LocalDate;

public class Factura {

	    private String idFactura;
	    private Cliente cliente;
	    private LocalDate fechaEmision;
	    private double montoTotal;

	    public Factura(String idFactura, Cliente cliente, double montoTotal) {
	        this.idFactura = idFactura;
	        this.cliente = cliente;
	        this.fechaEmision = LocalDate.now();
	        this.montoTotal = montoTotal;
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

	    // Getters y Setters
	    // Métodos para calcular impuestos y otros cargos si es necesario
	}

