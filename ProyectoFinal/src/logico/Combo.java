package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private double precio;
	private static int contadorId =100;
	private ArrayList<Componente> componentes;
	
	
	public Combo() {
		crearID();
		componentes = new ArrayList<Componente>();
		this.precio = 0;
	}
	
	private void crearID()
	{
		String id = "cb-"+contadorId;
		this.id = id;
		contadorId++;
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
