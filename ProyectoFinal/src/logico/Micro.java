package logico;

public class Micro extends Componente {
	private String tipoConexion;
	private int velocidadProc;
	
	public Micro(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, String tipoConexion,
			int velocidadProc) {
		super(numeroSerie, precio, cantidadDispo, marca, modelo);
		this.tipoConexion = tipoConexion;
		this.velocidadProc = velocidadProc;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public int getVelocidadProc() {
		return velocidadProc;
	}
	
}
