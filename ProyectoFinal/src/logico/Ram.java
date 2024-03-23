package logico;

public class Ram extends Componente {
	private int cantMemoria;
	private String tipoMemoria;
	public Ram(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, int cantMemoria,
			String tipoMemoria) {
		super(numeroSerie, precio, cantidadDispo, marca, modelo);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}
	public int getCantMemoria() {
		return cantMemoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	
}
