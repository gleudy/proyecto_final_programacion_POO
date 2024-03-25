package logico;

import java.util.ArrayList;

public class Tienda {
	private static Tienda tienda;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo> combos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	

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
	
	

}
