package logico;

public class MotherBoard extends Componente {
	private String tipoConector;
	private String tipoRam;
	private String conexiones;
	private String modelo;
	public MotherBoard(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo,
			String tipoConector, String tipoRam, String conexiones) {
		super(numeroSerie, precio, cantidadDispo, marca);
		this.tipoConector = tipoConector;
		this.tipoRam = tipoRam;
		this.conexiones = conexiones;
		this.modelo = modelo;
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
	
	@Override
	public String toString() {
		
		return this.getClass().getSimpleName()+"," + super.toString()+","+ this.modelo+ "," +this.tipoConector+","+this.tipoRam+","+this.conexiones;
	}
	public String getModelo() {
		// TODO Auto-generated method stub
		return modelo;
	}}
	
