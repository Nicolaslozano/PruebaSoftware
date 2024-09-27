package modelo;

public class DetalleAlta {
private String detalleConcepto;
private String unidad;
private Boolean superaLimite;
private double valor;
public DetalleAlta(String detalleConcepto, String unidad, Boolean superaLimite, double valor) {
	
	this.detalleConcepto = detalleConcepto;
	this.unidad = unidad;
	this.superaLimite = superaLimite;
	this.valor = valor;
}
public String getDetalleConcepto() {
	return detalleConcepto;
}
public void setDetalleConcepto(String detalleConcepto) {
	this.detalleConcepto = detalleConcepto;
}
public String getUnidad() {
	return unidad;
}
public void setUnidad(String unidad) {
	this.unidad = unidad;
}
public Boolean getSuperaLimite() {
	return superaLimite;
}
public void setSuperaLimite(Boolean superaLimite) {
	this.superaLimite = superaLimite;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}



}
