package logico;

public class Cliente {
	private int id;
	private String direccion;
	public Cliente(int id, String direccion) {
		this.id = id;
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return this.id + "," + this.direccion;
	}
	
	
	
	
}


