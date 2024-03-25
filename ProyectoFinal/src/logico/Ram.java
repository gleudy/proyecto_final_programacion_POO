package logico;

public class Ram extends Componente {
	private int capacidad;
	private String tipoMemoria;
	public Ram(String numeroSerie, double precio, int cantidadDispo, String marca, int capacidad,
			String tipoMemoria) {
		super(numeroSerie, precio, cantidadDispo, marca);
		this.capacidad = capacidad;
		this.tipoMemoria = tipoMemoria;
	}
	public int getCantMemoria() {
		return capacidad;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	
}
