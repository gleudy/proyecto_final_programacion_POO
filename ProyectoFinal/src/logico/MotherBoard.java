package logico;

public class MotherBoard extends Componente {
	private String tipoConector;
	private String tipoRam;
	private String conexiones;
	public MotherBoard(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo,
			String tipoConector, String tipoRam, String conexiones) {
		super(numeroSerie, precio, cantidadDispo, marca, modelo);
		this.tipoConector = tipoConector;
		this.tipoRam = tipoRam;
		this.conexiones = conexiones;
	}
	public String getTipoConector() {
		return tipoConector;
	}
	public String getTipoRam() {
		return tipoRam;
	}
	public String getConexiones() {
		return conexiones;
	}
	
}
