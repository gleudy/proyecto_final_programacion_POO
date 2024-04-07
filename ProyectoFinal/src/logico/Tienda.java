package logico;

import java.time.LocalDate;
import java.util.ArrayList;

import file.Guardar;

public class Tienda {
	private static Tienda tienda;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo> combos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Empleado> empleados;
	private ArrayList<Object> listaObjetos;
	private Guardar guardar;
	
	

	private Tienda()
	{
		componentes = new ArrayList<>();
		combos = new ArrayList<>();
		clientes = new ArrayList<>();
		facturas = new ArrayList<>();	
		empleados = new ArrayList<>();	
		this.guardar = Guardar.getInstance();
	}
	public static Tienda getInstance() {

		if (tienda == null) {
			tienda = new Tienda();

		}
		return tienda;
	}
	
	public  ArrayList<Componente> getComponentes() {
		this.componentes.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getComponente());
		for (Object objeto : listaObjetos) {
			Componente componente = (Componente) objeto;
		    this.componentes.add(componente);
		}
		
		return componentes;
		
	}
	
	public  ArrayList<Empleado> getEmpleados() {
		this.empleados.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getEmpleado());
		for (Object objeto : listaObjetos) {
			Empleado empleado = (Empleado) objeto;
		    this.empleados.add(empleado);
		}
		
		return empleados;
		
	}
	
	public  ArrayList<Cliente> getClientes() {
		clientes.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getCliente());
		for (Object objeto : listaObjetos) {
		    Cliente cliente = (Cliente) objeto;
		    this.clientes.add(cliente);
		}
		
		return clientes;
		
	}
	
	public  ArrayList<Combo> getCombo() {
		this.facturas.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getCombo());
		for (Object objeto : listaObjetos) {
		    Combo combo = (Combo) objeto;
		    this.combos.add(combo);
		}
		
		return combos;
		
	}
	
	public  ArrayList<Combo> getFacturas() {
		this.facturas.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getFactura());
		for (Object objeto : listaObjetos) {
		    Factura fac = (Factura) objeto;
		    this.facturas.add(fac);
		}
		
		return combos;
		
	}
	
	
	public void agregarComponente(Componente comp)
	{
		componentes.add(comp);
		listaObjetos = new ArrayList<>(this.componentes);
		guardar.guardarObjetos(listaObjetos, guardar.getComponente());
		
	}
	
	public void agregarCliente(Cliente cliente)
	{
		clientes.add(cliente);
		listaObjetos = new ArrayList<>(this.clientes);
		guardar.guardarObjetos(listaObjetos, guardar.getCliente());
		
		
	}

	public void agregarCombo(Combo combo)
	{
		this.combos.add(combo);
		listaObjetos = new ArrayList<>(this.combos);
		guardar.guardarObjetos(listaObjetos, guardar.getCombo());
	}
	
	public void agregarFactura(Factura factua)
	{
		this.facturas.add(factua);
		listaObjetos = new ArrayList<>(this.facturas);
		guardar.guardarObjetos(listaObjetos, guardar.getFactura());
	}
	
	public void agregarEmpleado(Empleado empleado)
	{
		this.empleados.add(empleado);
		listaObjetos = new ArrayList<>(this.empleados);
		guardar.guardarObjetos(listaObjetos, guardar.getFactura());
	}

	
	public boolean crearCombo(String id, ArrayList<Componente> componentes)
	{
		if(componentes.size()<3)
		{
			return false;
		}
		else
		{
			try {
				Combo cb = new Combo(id);
				this.agregarCombo(cb);
				for(Componente comp: componentes)
				{
					cb.agregarComponete(comp);
				}
				this.agregarCombo(cb);
				return true;
				}catch(Exception ex)
				{
					return false;
				}
		}
	}
	
	
	
}
