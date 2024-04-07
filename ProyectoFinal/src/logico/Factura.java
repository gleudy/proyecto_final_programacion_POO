package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static int contadorId =100;
	private static final long serialVersionUID = 1L;
	private String idFactura;
	private String idCliente;
	private LocalDate fecha;
	private double subTotal;
	private double itbis;
	private double total;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo>combos;

	public Factura(String idCliente, String idEmpleado) {
		componentes = new ArrayList<Componente>();
		combos = new ArrayList<Combo>();
		this.idFactura = crearID();
		this.idCliente = idCliente;
		this.fecha = LocalDate.now();
		calcularSubTotal();
		calcularItbis();
		calcularTotal();
		
		
	}
	private String crearID()
	{
		String id = "f-"+contadorId;
		this.idFactura = "f-"+contadorId;
		contadorId++;
		return id;
	}

	public void agregarComponente(Componente componente) {
		componentes.add(componente);
		this.calcularTotal();
	}
	
	public void agregarCombo(Combo combo) {
		combos.add(combo);
		this.calcularTotal();
	
	}
	
	public void calcularSubTotal()
	{
		double totalPrecioComponentes =0;
		double totalPrecioCombos=0;
	
		
		for(Componente comp: componentes)
		{
			totalPrecioComponentes+= comp.precioUnitario;
		}
		
		for(Combo comb: combos)
		{
			totalPrecioCombos+= comb.getPrecio();
		}
		
		this.subTotal = (totalPrecioComponentes + totalPrecioCombos);
		
		
		
	}
	
	public void calcularItbis()
	{
		this.calcularSubTotal();
		this.itbis =  this.subTotal*0.18;
		

	}
	
	public void calcularTotal()
	{
		this.calcularItbis();
		this.total = subTotal+itbis;

	}
	
	

}
