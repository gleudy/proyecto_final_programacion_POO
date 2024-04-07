package logico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private String idFactura;
	private String idCliente;
	private LocalDate fecha;
	private double subTotal;
	private double itbis;
	private double total;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo>combos;
	public Factura() {

	}

	private Factura(String idFactura, String idCliente) {
		componentes = new ArrayList<Componente>();
		combos = new ArrayList<Combo>();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.fecha = LocalDate.now();
		this.subTotal = calcularSubTotal();
		this.itbis = calcularItbis();
		this.subTotal = calcularTotal();
		
		
	}

	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}
	
	public void agregarCombo(Combo combo) {
		combos.add(combo);
	
	}
	
	public double calcularSubTotal()
	{
		double totalPrecioComponentes =0;
		double totalPrecioCombos=0;
		double itbis=0;
		
		for(Componente comp: componentes)
		{
			totalPrecioComponentes+= comp.precioUnitario;
		}
		
		for(Combo comb: combos)
		{
			totalPrecioCombos+= comb.getPrecio();
		}
		
		itbis = (totalPrecioComponentes + totalPrecioCombos);
		
		
		return itbis;
	}
	
	public double calcularItbis()
	{
		double itbis = calcularSubTotal()*0.18;
		return itbis;

	}
	
	public double calcularTotal()
	{
		double subTotal = calcularSubTotal();
		double itbis = calcularSubTotal()*0.18;
		return subTotal+itbis;

	}
	
	

}
