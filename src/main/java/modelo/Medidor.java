package modelo;

public class Medidor {
private Cliente cliente;
private int nroSerie;
private String domicilioMedidor;
private Tarifa tarifa;
private boolean esBaja;
public Medidor(Cliente cliente, int nroSerie, String domicilioMedidor, Tarifa tarifa, boolean esBaja) {
	
	this.cliente = cliente;
	this.nroSerie = nroSerie;
	this.domicilioMedidor = domicilioMedidor;
	this.tarifa = tarifa;
	this.esBaja = esBaja;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public int getNroSerie() {
	return nroSerie;
}
public void setNroSerie(int nroSerie) {
	this.nroSerie = nroSerie;
}
public String getDomicilioMedidor() {
	return domicilioMedidor;
}
public void setDomicilioMedidor(String domicilioMedidor) {
	this.domicilioMedidor = domicilioMedidor;
}
public Tarifa getTarifa() {
	return tarifa;
}
public void setTarifa(Tarifa tarifa) {
	this.tarifa = tarifa;
}
public boolean isEsBaja() {
	return esBaja;
}
public void setEsBaja(boolean esBaja) {
	this.esBaja = esBaja;
}





}
