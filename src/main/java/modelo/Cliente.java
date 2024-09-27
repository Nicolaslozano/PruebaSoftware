package modelo;

public class Cliente {
	private int idCliente;
	private long contacto;
	private String domicilio;
	
	
	public Cliente(int idCliente, long contacto, String domicilio) {
		
		this.idCliente = idCliente;
		this.contacto = contacto;
		this.domicilio = domicilio;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public long getContacto() {
		return contacto;
	}
	public void setContacto(long contacto) {
		this.contacto = contacto;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	
	
}
