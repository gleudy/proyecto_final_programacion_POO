package logico;

public class Disco extends Componente {
	private int almacenamiento;
	private String tipoConexion;
	private String modelo;
	
	public Disco(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, int almacenamiento,
			String tipoConexion) {
		super(numeroSerie, precio, cantidadDispo, marca);
		this.almacenamiento = almacenamiento;
		this.tipoConexion = tipoConexion;
		this.modelo = modelo;
	}
	public int getAlmacenamiento() {
		return almacenamiento;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	
	
}
