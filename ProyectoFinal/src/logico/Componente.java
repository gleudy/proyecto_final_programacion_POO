package logico;

public class Componente {
	protected String numeroSerie;
	protected double precio;
	protected int cantidadDispo;
	protected String marca;
	protected String modelo;
	
	public Componente(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo) {
		this.numeroSerie = numeroSerie;
		this.precio = precio;
		this.cantidadDispo = cantidadDispo;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
}
