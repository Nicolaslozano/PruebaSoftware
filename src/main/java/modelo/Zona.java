package modelo;

import java.util.ArrayList;
import java.util.List;


public class Zona {
private String nombreZona;
private List<Inspector> lstInspector = new ArrayList<Inspector>();



public Zona(String nombreZona) {

	this.nombreZona = nombreZona;
}
public String getNombreZona() {
	return nombreZona;
}
public void setNombreZona(String nombreZona) {
	this.nombreZona = nombreZona;
}
public List<Inspector> getLstInspector() {
	return lstInspector;
}
public void setLstInspector(List<Inspector> lstInspector) {
	this.lstInspector = lstInspector;
}








	


}
