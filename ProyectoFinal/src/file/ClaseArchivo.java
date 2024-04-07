package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logico.Persona;
import logico.Componente;
import logico.Disco;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;
import logico.Tienda;

public class ClaseArchivo 
{
	private  File directorio;
	private File componente;
	private File cliente;
	private File combo;
	private File factura;
	private FileReader lector;
	private BufferedReader lectura;
	private String cadena ="";

	private String rutaDirectorio = "DataBase";

	public ClaseArchivo() {
		directorio = new File(rutaDirectorio);
		crearDirecctorio();
		crearArchivos();
	}
	

	private boolean crearDirecctorio()
	{
		System.out.println(directorio.exists());
		if(!directorio.exists())
		{
			if(directorio.mkdir())
			{
				return true;		
			}
			else
			{
				return false;	
			}	
		}

		return false;
	}

	private boolean crearArchivos()
	{
		componente = new File(rutaDirectorio+File.separator + "componente.txt");
		
		cliente = new File(rutaDirectorio+File.separator + "cliente.txt");
		combo = new File(rutaDirectorio+File.separator + "combo.txt");
		factura = new File(rutaDirectorio+File.separator + "factura.txt");
		try {
			componente.createNewFile();
			cliente.createNewFile();
			combo.createNewFile();
			factura.createNewFile();
			return true;
	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean guardarComponete(ArrayList<Componente> comp)
	{
		if(directorio.exists() && componente.exists())
		{
			try {
				FileWriter escribir = new FileWriter(componente);
				for(Componente c: comp)
				{
					escribir.write(c.toString()+"\r\n");
				}
				escribir.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;

	}
	
	public ArrayList<Componente> obtenerComponentes()
	{
		ArrayList<Componente> componentes = new ArrayList();
		String cadena ="";
		try {
			lector = new FileReader(componente);
			lectura = new BufferedReader(lector);
			Componente componete;
		
				cadena = lectura.readLine();
				while(cadena!=null)
				{
					String[] lista = cadena.split(",");
					if(lista[0].equalsIgnoreCase("Disco"))
					{
						componete = new Disco(lista[1] ,Double.parseDouble(lista[2]),Integer.parseInt(lista[3]),lista[4],lista[5],Integer.parseInt(lista[6]),lista[7]);
					}
					else if(lista[0].equalsIgnoreCase("Micro"))
					{
						componete = new Micro(lista[1] ,Double.parseDouble(lista[2]),Integer.parseInt(lista[3]),lista[4],lista[5],lista[6],Integer.parseInt(lista[7]));
					
					}
					else if(lista[0].equalsIgnoreCase("MotherBoard"))
					{
						componete = new MotherBoard(lista[1] ,Double.parseDouble(lista[2]),Integer.parseInt(lista[3]),lista[4],lista[5],lista[6],lista[7],lista[7]);	
					}
					else
					{
						componete = new Ram(lista[1] ,Double.parseDouble(lista[2]),Integer.parseInt(lista[3]),lista[4],Integer.parseInt(lista[5]),lista[6]);
					}
			
					componentes.add(componete);
					cadena = lectura.readLine();
					
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return componentes;
	}

	public boolean guardarCliente(ArrayList<Persona> clientes)
	{
		if(directorio.exists() && cliente.exists())
		{
			try {
				FileWriter escribir = new FileWriter(cliente);
				for(Persona c: clientes)
				{
					escribir.write(c.toString()+"\r\n");
				}
				escribir.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;

	}
	/*
	public ArrayList<Persona> obtenerClientes()
	{ 
		ArrayList<Persona> clientes = new ArrayList();
		String cadena ="";
		try {
			lector = new FileReader(cliente);
			lectura = new BufferedReader(lector);
			Persona cliente;
		
				cadena = lectura.readLine();
				while(cadena!=null)
				{
					String[] lista = cadena.split(",");
					cliente = new Persona(Integer.parseInt(lista[0]),lista[1]);
					clientes.add(cliente);
					cadena = lectura.readLine();
					
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
		
	}

	*/
	
}

