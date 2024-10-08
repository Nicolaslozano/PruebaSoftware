package modelo;

public class Cliente {

	private String nombre;
	private String direccion;
	private String tipoCliente; // Residencial, Comercial, Industrial
	private int idCliente;
	private Medidor medidor;
	private int edad;

	public Cliente(int idCliente, String nombre, String direccion, String tipoCliente, int edad) {
		setIdCliente(idCliente);
		setNombre(nombre);
		setDireccion(direccion);
		setTipoCliente(tipoCliente);
		setEdad(edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
		if (nombre.matches("^[0-9]+$")) { // Verifica si el nombre contiene solo números
			throw new IllegalArgumentException("El nombre no puede ser un número.");
		}
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || direccion.trim().isEmpty()) {
			throw new IllegalArgumentException("La dirección no puede estar vacía.");
		}
		this.direccion = direccion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		if (tipoCliente == null ||
				(!tipoCliente.equalsIgnoreCase("Residencial") &&
						!tipoCliente.equalsIgnoreCase("Comercial") &&
						!tipoCliente.equalsIgnoreCase("Industrial"))) {
			throw new IllegalArgumentException("Tipo de cliente inválido. Debe ser 'Residencial', 'Comercial' o 'Industrial'.");
		}
		this.tipoCliente = tipoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		if (idCliente <= 0) {
			throw new IllegalArgumentException("El ID del cliente debe ser un número positivo.");
		}
		this.idCliente = idCliente;
	}

	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 0) {
			throw new IllegalArgumentException("La edad no puede ser negativa.");
		}
		this.edad = edad;
	}
}
