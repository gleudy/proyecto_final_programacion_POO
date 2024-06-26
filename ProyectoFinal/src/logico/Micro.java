package logico;

public class Micro extends Componente {
	private String tipoConexion;
	private int velocidadProc;
	private String modelo;
	
	public Micro(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, String tipoConexion,
			int velocidadProc) {
		super(numeroSerie, precio, cantidadDispo, marca);
		this.tipoConexion = tipoConexion;
		this.velocidadProc = velocidadProc;
		this.modelo = modelo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public int getVelocidadProc() {
		return velocidadProc;
	}
	
	@Override
	public String toString() {
		
		return this.getClass().getSimpleName()+"," + super.toString()+","+ this.modelo+ "," +this.tipoConexion+","+this.velocidadProc;
	}

	public String getModelo() {
		
		return modelo;
	}
	
	
}
