package modelo;

public class Consumo {

	    private Cliente cliente;
	    private double consumoTotal;

	    public Consumo(Cliente cliente) {
	        this.cliente = cliente;
	        this.consumoTotal = 0;
	    }

	    public void actualizarConsumo(double consumo) {
	        this.consumoTotal += consumo;
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

}
