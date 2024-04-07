package logico;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoCliente;

	public Cliente(String cedula, String nombre, String direccion, String telefono, String tipoCliente) {
		super(cedula, nombre, direccion, telefono);
		this.tipoCliente = tipoCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return super.toString() +","+ this.tipoCliente;
	}
	
	

}
