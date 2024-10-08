package modelo;

public class Medidor {

	    private String idMedidor;
	    private double lecturaActual;
	    private double lecturaAnterior;

	    public Medidor(String idMedidor) {
	        this.idMedidor = idMedidor;
	        this.lecturaActual = 0;
	        this.lecturaAnterior = 0;
	    }

	    public void registrarLectura(double nuevaLectura) {
	        this.lecturaAnterior = this.lecturaActual;
	        this.lecturaActual = nuevaLectura;
	    }

	    public double calcularConsumo() {
	        return this.lecturaActual - this.lecturaAnterior;
	    }

		public String getIdMedidor() {
			return idMedidor;
		}

		public void setIdMedidor(String idMedidor) {
			this.idMedidor = idMedidor;
		}

		public double getLecturaActual() {
			return lecturaActual;
		}

		public void setLecturaActual(double lecturaActual) {
			this.lecturaActual = lecturaActual;
		}

		public double getLecturaAnterior() {
			return lecturaAnterior;
		}

		public void setLecturaAnterior(double lecturaAnterior) {
			this.lecturaAnterior = lecturaAnterior;
		}

	    // Getters y Setters
	}
