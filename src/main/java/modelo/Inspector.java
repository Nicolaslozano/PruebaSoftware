package modelo;

import java.util.ArrayList;
import java.util.List;


public class Inspector {
private long contacto;
private List<Zona> lstZonas=new ArrayList<Zona>();

public Inspector(long contacto) {
	
	this.contacto = contacto;
	
}

public long getContacto() {
	return contacto;
}

public void setContacto(long contacto) {
	this.contacto = contacto;
}

public List<Zona> getLstZonas() {
	return lstZonas;
}

public void setLstZonas(List<Zona> lstZonas) {
	this.lstZonas = lstZonas;
}



}
