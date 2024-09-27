package modelo;

public class ClienteFisico extends Cliente {

private String nombre;
private String apellido;
private long dni;


public ClienteFisico(int idCliente, long contacto, String domicilio, String nombre, String apellido, long dni) {
	super(idCliente, contacto, domicilio);
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public long getDni() {
	return dni;
}
public void setDni(long dni) {
	this.dni = dni;
}
@Override
public String toString() {
	return "ClienteFisico [idCliente=" + getIdCliente() + ", Contacto=" + getContacto() + ", Domicilio="
			+ getDomicilio() + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
}





}

	











