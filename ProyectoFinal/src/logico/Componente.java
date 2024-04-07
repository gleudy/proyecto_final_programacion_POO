package logico;

import java.io.Serializable;

public class Componente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String numeroSerie;
	protected double precioUnitario;
	protected int cantidadDispo;
	protected String marca;
	
	public Componente(String numeroSerie, double precio, int cantidadDispo, String marca) {
		this.numeroSerie = numeroSerie;
		this.precioUnitario = precio;
		this.cantidadDispo = cantidadDispo;
		this.marca = marca;
	
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public double getPrecio() {
		return precioUnitario;
	}

	public int getCantidadDispo() {
		return cantidadDispo;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return numeroSerie + ","+ precioUnitario + ","+cantidadDispo + "," + marca;
	}


	
	
}
