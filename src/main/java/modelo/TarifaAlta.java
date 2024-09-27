package modelo;

import java.util.ArrayList;
import java.util.List;

public class TarifaAlta {
private String tensionContratada;
private int limite;
private List<DetalleAlta>listDetalle=new ArrayList<DetalleAlta>();

public TarifaAlta(String tensionContratada, int limite, List<DetalleAlta> listDetalle) {
	
	this.tensionContratada = tensionContratada;
	this.limite = limite;
	this.listDetalle = listDetalle;
}

public String getTensionContratada() {
	return tensionContratada;
}

public void setTensionContratada(String tensionContratada) {
	this.tensionContratada = tensionContratada;
}

public int getLimite() {
	return limite;
}

public void setLimite(int limite) {
	this.limite = limite;
}

public List<DetalleAlta> getListDetalle() {
	return listDetalle;
}

public void setListDetalle(List<DetalleAlta> listDetalle) {
	this.listDetalle = listDetalle;
}


}
