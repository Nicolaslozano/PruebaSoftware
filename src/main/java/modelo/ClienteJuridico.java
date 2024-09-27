package modelo;

public class ClienteJuridico extends Cliente{

private long cuit;
private String razonSocial;

public ClienteJuridico(int idCliente, long contacto, String domicilio, long cuit, String razonSocial) {
	super(idCliente, contacto, domicilio);
	this.cuit = cuit;
	this.razonSocial = razonSocial;
}
public long getCuit() {
	return cuit;
}
public void setCuit(long cuit) {
	this.cuit = cuit;
}
public String getRazonSocial() {
	return razonSocial;
}
public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

@Override
public String toString() {
	return "ClienteJuridico [IdCliente=" + getIdCliente() + ", Contacto=" + getContacto()
			+ ", Domicilio=" + getDomicilio() + ", cuit=" + cuit + ", razonSocial=" + razonSocial + "]";
}






}
