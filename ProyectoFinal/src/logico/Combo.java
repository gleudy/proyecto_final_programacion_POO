package logico;

import java.util.ArrayList;

public class Combo {
	private String id;
	private double precio;
	private ArrayList<Componente> componentes;
	
	
	public Combo(String id) {
		this.id = id;
		componentes = new ArrayList<Componente>();
		this.precio = 0;
	}
	
	public int agregarComponete(Componente comp)
	{
		componentes.add(comp);
		calcularPrecio();
		return componentes.size();
		
	}
	
	private void calcularPrecio()
	{
		double precioTotal =0;
		for(Componente comp: componentes)
		{
			precioTotal+= comp.precioUnitario;
		}
		precio = precioTotal - precioTotal*0.3;
	}
	
	
	public String getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public double precioOferta() {
		return this.precio * 0.10;
	}
	
}
