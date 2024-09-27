package modelo;

import java.util.ArrayList;
import java.util.List;

public class TarifaBaja {
private List<DetalleBaja>lstDetalleB=new ArrayList<DetalleBaja>();

public TarifaBaja(List<DetalleBaja> lstDetalleB) {

	this.lstDetalleB = lstDetalleB;
}

public List<DetalleBaja> getLstDetalleB() {
	return lstDetalleB;
}

public void setLstDetalleB(List<DetalleBaja> lstDetalleB) {
	this.lstDetalleB = lstDetalleB;
}


}
