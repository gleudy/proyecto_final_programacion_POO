package logico;

import java.util.ArrayList;

import file.ClaseArchivo;

public class Tienda {
	private static Tienda tienda;
	static private ArrayList<Componente> componentes;
	private ArrayList<Combo> combos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private static ClaseArchivo cArchico= new ClaseArchivo();
	

	private Tienda()
	{
		componentes = new ArrayList<>();
		combos = new ArrayList<>();
		clientes = new ArrayList<>();
		facturas = new ArrayList<>();	
	}
	public static Tienda getInstance() {

		if (tienda == null) {
			tienda = new Tienda();

		}
		return tienda;
	}
	public static ArrayList<Componente> getComponentes() {
		componentes = cArchico.obtenerComponentes();
		return componentes;
		
	}
	
	public static void agregarComponente(Componente comp)
	{
		componentes.add(comp);
		cArchico.guardarComponete(componentes);
		
		
	}

	
	
	
	

}
