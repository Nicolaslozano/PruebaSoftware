package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaEdeUnla {

	private List<ClienteJuridico> lstClienteJurd = new ArrayList<ClienteJuridico>();
	private List<ClienteFisico> lstClienteFisico = new ArrayList<ClienteFisico>();
	private List<Inspector> lstInspector = new ArrayList<Inspector>();
	private List<Zona> lstZonas = new ArrayList<Zona>();
	private List<Medidor> lstMedidor = new ArrayList<Medidor>();
	private List<DetalleBaja> lstDetalleBaja = new ArrayList<DetalleBaja>();
	private List<DetalleAlta> lstDetalleAlta = new ArrayList<DetalleAlta>();

	public List<ClienteJuridico> getLstClienteJurd() {
		return lstClienteJurd;
	}

	public void setLstClienteJurd(List<ClienteJuridico> lstClienteJurd) {
		this.lstClienteJurd = lstClienteJurd;
	}

	public List<ClienteFisico> getLstClienteFisico() {
		return lstClienteFisico;
	}

	public void setLstClienteFisico(List<ClienteFisico> lstClienteFisico) {
		this.lstClienteFisico = lstClienteFisico;
	}

	public List<Inspector> getLstInspector() {
		return lstInspector;
	}

	public void setLstInspector(List<Inspector> lstInspector) {
		this.lstInspector = lstInspector;
	}

	public List<Zona> getLstZonas() {
		return lstZonas;
	}

	public void setLstZonas(List<Zona> lstZonas) {
		this.lstZonas = lstZonas;
	}

	public List<Medidor> getLstMedidor() {
		return lstMedidor;
	}

	public void setLstMedidor(List<Medidor> lstMedidor) {
		this.lstMedidor = lstMedidor;
	}

	public List<DetalleBaja> getLstDetalleBaja() {
		return lstDetalleBaja;
	}

	public void setLstDetalleBaja(List<DetalleBaja> lstDetalleBaja) {
		this.lstDetalleBaja = lstDetalleBaja;
	}

	public List<DetalleAlta> getLstDetalleAlta() {
		return lstDetalleAlta;
	}

	public void setLstDetalleAlta(List<DetalleAlta> lstDetalleAlta) {
		this.lstDetalleAlta = lstDetalleAlta;
	}

	@Override
	public String toString() {
		return "SistemaEdeUnla [lstClienteJurd=" + lstClienteJurd + ", lstClienteFisico=" + lstClienteFisico
				+ ", lstInspector=" + lstInspector + ", lstZonas=" + lstZonas + ", lstMedidor=" + lstMedidor
				+ ", lstDetalleBaja=" + lstDetalleBaja + ", lstDetalleAlta=" + lstDetalleAlta + "]";
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ClienteFisico traerClienteFisico(int idCliente) {
		int i = 0;
		ClienteFisico encontrado = null;
		while (encontrado == null && i < lstClienteFisico.size()) {
			ClienteFisico c = lstClienteFisico.get(i);
			if (idCliente == c.getIdCliente()) {
				encontrado = c;

			}
			i++;

		}
		return encontrado;
	}

	public boolean altaClienteFisico(long contacto, String domicilio, String nombre, String apellido, long dni)
			throws Exception {
		int idCliente = 0;

		if (traerClienteFisico(idCliente) != null)
			throw new Exception("El cliente ya existe en el sistema");
		else {
			if (lstClienteFisico.size() != 0) {
				idCliente = lstClienteFisico.get(lstClienteFisico.size() - 1).getIdCliente() + 1;
			}
		}
		return lstClienteFisico.add(new ClienteFisico(idCliente, contacto, domicilio, nombre, apellido, dni));

	}

	public boolean bajaClienteFisico(int idCliente) throws Exception {
		boolean flag = true;

		if (traerClienteFisico(idCliente) != null)
			lstClienteFisico.remove(idCliente);

		else {
			flag = false;
			throw new Exception("el cliente no existe en el sistema");

		}
		return flag;
	}

	public ClienteFisico modClienteFisico(int idCliente, long contacto, String domicilio, String nombre,
			String apellido, long dni) throws Exception {
		ClienteFisico c = traerClienteFisico(idCliente);
		if (c == null)
			throw new Exception("El Cliente no existe en el sistema");

		else {
			c.setContacto(contacto);
			c.setDomicilio(domicilio);
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setDni(dni);
		}
		return c;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ClienteJuridico traerClienteJuridico(int idCliente) {
		int i = 0;
		ClienteJuridico encontrado = null;
		while (encontrado == null && i < lstClienteJurd.size()) {
			ClienteJuridico c = lstClienteJurd.get(i);
			if (idCliente == c.getIdCliente()) {
				encontrado = c;
			}
			return encontrado;
		}
		return encontrado;
	}

	public boolean altaClienteJuridico(long contacto, String domicilio, String RazonSocial, long cuit)
			throws Exception {
		int idCliente = 0;

		if (traerClienteJuridico(idCliente) != null) {
			throw new Exception("El cliente ya existe en el sistema");
		} else {
			if (lstClienteJurd.size() != 0) {
				idCliente = lstClienteJurd.get(lstClienteJurd.size() - 1).getIdCliente() + 1;
			}

		}
		return lstClienteJurd.add(new ClienteJuridico(idCliente, contacto, domicilio, cuit, RazonSocial));

	}

	public boolean bajaClienteJuridico(int idCliente) throws Exception {
		boolean flag = true;

		if (traerClienteJuridico(idCliente) != null) {
			lstClienteJurd.remove(idCliente);
		} else {
			throw new Exception("El cliente no existe en el sistema");
		}

		return flag;

	}

	public ClienteJuridico modClienteJuridico(int idCliente, long contacto, String domicilio, String razonSocial,
			long cuit) throws Exception {
		ClienteJuridico c = traerClienteJuridico(idCliente);
		if (c == null) {
			throw new Exception("El cliente no existe en el sistema");

		} else {
			c.setContacto(contacto);
			c.setDomicilio(domicilio);
			c.setRazonSocial(razonSocial);
			c.setCuit(cuit);

		}
		return c;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Zona traerZona(String nombreZona) {
		int i = 0;
		Zona encontrado = null;
		while (encontrado == null && i < lstZonas.size()) {
			Zona z = lstZonas.get(i);
			if (nombreZona == z.getNombreZona())
				encontrado = z;
		}
		return encontrado;
	}
		public boolean altaZona(String nombreZona)throws Exception{
			if(traerZona(nombreZona)!=null) {
				throw new Exception("La zona ya existe en el sistema");
			}
			else {
				return lstZonas.add(new Zona(nombreZona));
			}
			
		}
		public boolean bajaZona(String nombreZona)throws Exception {
			
			if(traerZona(nombreZona)==null) {
				throw new Exception("La zona no existe en el sistema");
			}
			else {
				return lstZonas.remove(new Zona(nombreZona));
			}
			
		}
		
		
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
		public Inspector traerInspector(long contacto) {
			int i=0;
			Inspector encontrado=null;
			while(encontrado==null && i<lstInspector.size()) {
				Inspector in=lstInspector.get(i);
				if(contacto==in.getContacto()) {
					encontrado=in;
				}
			}
			return encontrado;
		}
	
		public boolean altaInspector(long contacto,List<Zona> lstZona)throws Exception {
			if(traerInspector(contacto) !=null) {
				throw new Exception("El inspector ya existe en el sistema");
				
			}
			else {
			return lstInspector.add(new Inspector(contacto));
			}
			
		}
		public boolean bajaInspector(long contacto)throws Exception {
			if(traerInspector(contacto) ==null) {
				throw new Exception("El inspector no existe en el sistema");
				
			}
			else {
			return lstInspector.add(new Inspector(contacto));
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
