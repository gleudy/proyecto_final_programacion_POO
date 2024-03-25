package logico;

import java.util.ArrayList;

public class Combo {
	private String id;
	private String prueba;
	private double precio;
	private ArrayList<Componente> componentes;
	
	
	public Combo(String id, double precio) {
		this.id = id;
		this.precio = precio;
		componentes = new ArrayList<Componente>();
	}
	
	public void agregarComponentes(Componente componente)
	{
		ArrayList<Componente> componentesTienda = Tienda.getComponentes();
		
		for(Componente comp: componentesTienda )
		{
			for(Componente compLocal:componentes )
			{
				if(!compLocal.getClass().equals(comp.getClass()))
				{
					componentes.add(comp);
				}
			}
		}
	
		
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
