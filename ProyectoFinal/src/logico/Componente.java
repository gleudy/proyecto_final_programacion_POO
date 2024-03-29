package logico;

public class Componente {
	protected String numeroSerie;
	protected double precio;
	protected int cantidadDispo;
	protected String marca;
	
	public Componente(String numeroSerie, double precio, int cantidadDispo, String marca) {
		this.numeroSerie = numeroSerie;
		this.precio = precio;
		this.cantidadDispo = cantidadDispo;
		this.marca = marca;
	
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidadDispo() {
		return cantidadDispo;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return numeroSerie + ","+ precio + ","+cantidadDispo + "," + marca;
	}


	
	
}
