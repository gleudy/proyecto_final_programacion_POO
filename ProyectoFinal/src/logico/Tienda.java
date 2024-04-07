package logico;

import java.util.ArrayList;

import file.ClaseArchivo;

public class Tienda {
	private static Tienda tienda;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo> combos;
	private ArrayList<Persona> clientes;
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
	public  ArrayList<Componente> getComponentes() {
		//componentes = cArchico.obtenerComponentes();
		return componentes;
		
	}
	
	public void agregarComponente(Componente comp)
	{
		componentes.add(comp);
		//cArchico.guardarComponete(componentes);
	}
	
	public void agregarCliente(Persona cliente)
	{
		clientes.add(cliente);
		//cArchico.guardarCliente(clientes);
	}

	public  ArrayList<Persona> getClientes() {
		//clientes = cArchico.obtenerClientes();
		return clientes;
		
	}
	
	
	
	

}
