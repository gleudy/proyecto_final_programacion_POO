package logico;

public class Disco extends Componente {
	private int almacenamiento;
	private String tipoConexion;
	public Disco(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, int almacenamiento,
			String tipoConexion) {
		super(numeroSerie, precio, cantidadDispo, marca, modelo);
		this.almacenamiento = almacenamiento;
		this.tipoConexion = tipoConexion;
	}
	public int getAlmacenamiento() {
		return almacenamiento;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	
}
