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
		this.getComponentes();
		this.getClientes();
		this.getEmpleados();
		this.getFacturas();
		this.getCombo();
	}
	public static Tienda getInstance() {

		if (tienda == null) {
			tienda = new Tienda();

		}
		return tienda;
	}
	
	public  ArrayList<Componente> getComponentes() {
		try {
		this.componentes.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getComponente());
		for (Object objeto : listaObjetos) {
			Componente componente = (Componente) objeto;
		    this.componentes.add(componente);
		}
		} catch(Exception ex)
		{
			
		}
		return componentes;
		
	}
	
	public  ArrayList<Empleado> getEmpleados() {
		try {
		this.empleados.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getEmpleado());
		for (Object objeto : listaObjetos) {
			Empleado empleado = (Empleado) objeto;
		    this.empleados.add(empleado);
		}
		}catch(Exception ex)
		{
			
		}
		return empleados;
		
	}
	
	public  ArrayList<Cliente> getClientes() {
		try {
		clientes.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getCliente());
		for (Object objeto : listaObjetos) {
		    Cliente cliente = (Cliente) objeto;
		    this.clientes.add(cliente);
		}
		}catch(Exception ex)
		{
			
		}
		return clientes;
		
	}
	
	public  ArrayList<Combo> getCombo() {
		try {
		this.facturas.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getCombo());
		for (Object objeto : listaObjetos) {
		    Combo combo = (Combo) objeto;
		    this.combos.add(combo);
		}
		}catch(Exception ex)
		{
			
		}
		return combos;
		
	}
	
	public  ArrayList<Combo> getFacturas() {
		try {
		this.facturas.clear();
		this.listaObjetos = new ArrayList<>();
		this.listaObjetos = guardar.recuperarObjetos(this.guardar.getFactura());
		for (Object objeto : listaObjetos) {
		    Factura fac = (Factura) objeto;
		    this.facturas.add(fac);
		}
		}catch(Exception ex)
		{
			
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

	
	public boolean crearCombo(ArrayList<Componente> componentes)
	{
		if(componentes.size()<3)
		{
			return false;
		}
		else
		{
			try {
				Combo cb = new Combo();
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
	
	public boolean crearCliente(String cedula, String nombre, String direccion, String telefono, String tipoCliente)
	{
		if(validarSiClienteExiste(cedula)) 
		{
			return false;
		}
		else
		{
			if(validarCedula(cedula))
			{
				Cliente cl = new Cliente(cedula,nombre,direccion,telefono,tipoCliente);
				agregarCliente(cl);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean crearEmpleado(String cedula, String nombre, String direccion, String telefono, LocalDate fechaIngreso, String cargo, double sueldo)
	{
		if(validarSiEmpleadoExiste(cedula)) 
		{
			return false;
		}
		else
		{
			if(validarCedula(cedula))
			{
				Empleado emp = new Empleado(cedula,nombre,direccion,telefono,fechaIngreso,cargo,sueldo);
				agregarEmpleado(emp);
				return true;
			}
		}
		
		return false;
		
		
	}

	public boolean crearDisco(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, int almacenamiento,
			String tipoConexion)
	{
		if(validarSiComponeteExiste(numeroSerie))
		{
			return false;
		}
		else
		{
			this.agregarComponente(new Disco(numeroSerie, precio, cantidadDispo,  marca,  modelo, almacenamiento, tipoConexion));
			return true;
		}

	}
	
	public boolean crearMicro(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo, String tipoConexion,
			int velocidadProcn)
	{
		if(validarSiComponeteExiste(numeroSerie))
		{
			return false;
		}
		else
		{
			this.agregarComponente(new Micro(numeroSerie, precio, cantidadDispo,  marca,  modelo, tipoConexion, velocidadProcn));
			return true;
		}

	}

	public boolean crearMotherBoard(String numeroSerie, double precio, int cantidadDispo, String marca, String modelo,
			String tipoConector, String tipoRam, String conexiones)
	{
		if(validarSiComponeteExiste(numeroSerie))
		{
			return false;
		}
		else
		{
			this.agregarComponente(new MotherBoard(numeroSerie, precio, cantidadDispo, marca, modelo,
					tipoConector, tipoRam, conexiones));
			return true;
		}

	}

	public boolean crearRam(String numeroSerie, double precio, int cantidadDispo, String marca, int capacidad,
			String tipoMemoria) {
	
		if(validarSiComponeteExiste(numeroSerie))
		{
			return false;
		}
		else
		{
			this.agregarComponente(new Ram(numeroSerie, precio, cantidadDispo, marca,capacidad,tipoMemoria));
			return true;
		}

	}

	public boolean crearFactura(String idCliente, String idEmpleado,ArrayList<Componente> cpts,ArrayList<Combo>cbs)
	{
		if(validarSiEmpleadoExiste(idEmpleado) && validarSiClienteExiste(idCliente))
		{
			if(cpts.size()>1|| cbs.size()>1)
			{
				Factura fact = new Factura(idCliente,idEmpleado);
				for(Componente cmp:cpts)
				{
					fact.agregarComponente(cmp);
				}
				for(Combo cb:cbs)
				{
					fact.agregarCombo(cb);
				}
				return true;
			}
		}
		return false;
	}
	
	
	private boolean validarSiClienteExiste(String cedula)
	{
		for(Cliente cl: clientes)
		{
			if(cl.getCedula().equalsIgnoreCase(cedula))
			{
				return true;
			}
			
		}
		return false;
	}

	private boolean validarSiFacturaExiste(String id)
	{
		for(Factura ft: facturas)
		{
			if(ft.getIdFactura().equalsIgnoreCase(id))
			{
				return true;
			}
			
		}
		return false;
	}

	private boolean validarSiEmpleadoExiste(String cedula)
	{
		for(Empleado emp: empleados)
		{
			if(emp.getCedula().equalsIgnoreCase(cedula))
			{
				return true;
			}
			
		}
		return false;
	}
	
	private boolean validarSiComponeteExiste(String numeroSerie)
	{
		for(Componente comp: componentes)
		{
			if(comp.numeroSerie.equalsIgnoreCase(numeroSerie))
			{
				return true;
			}
		}
		return false;
	}

	
	
	private boolean validarCedula(String cedula)
	{
		boolean isValid = false;
		String cd = cedula.replace("-", "");
		if(cd.length()==11)
		{
			if(cd.matches("[0-9]+")){
				isValid=true;
			}
		}

		return isValid;
		
	}
}
