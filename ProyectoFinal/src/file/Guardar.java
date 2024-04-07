package file;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logico.Componente;



public class Guardar 
{

	private  File directorio;
	private  File componente;
	private  File cliente;
	private  File combo;
	private  File factura;
	private  File empleado;
	private String  nombreArchivoComponete;
	private String  nombreArchivoFactura;
	private String  nombreArchivoCliente;
	private String  nombreArchivoCombo;
	private String  nombreArchivoEmpleado;
	private String rutaDirectorio;
	private static Guardar guardar;
	
	
	private Guardar() {
		rutaDirectorio = "DataBase";
		directorio = new File(rutaDirectorio);
		crearDirecctorio();
		nombreArchivoComponete = "componentes.bin";
		nombreArchivoFactura = "facturas.bin";
		nombreArchivoCliente= "clientes.bin";
		nombreArchivoCombo= "combos.bin";
		nombreArchivoEmpleado= "empleados.bin";
		crearArchivos();
		
	}
	
	public static Guardar getInstance() {

		if (guardar == null) {
			guardar = new Guardar();

		}
		return guardar;
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
		componente = new File(rutaDirectorio+File.separator + nombreArchivoComponete);
		cliente = new File(rutaDirectorio+File.separator + nombreArchivoCliente);
		combo = new File(rutaDirectorio+File.separator + nombreArchivoCombo);
		factura = new File(rutaDirectorio+File.separator + nombreArchivoFactura);
		empleado = new File(rutaDirectorio+File.separator + nombreArchivoEmpleado);

		try {
			componente.createNewFile();
			cliente.createNewFile();
			combo.createNewFile();
			factura.createNewFile();
			empleado.createNewFile();
			return true;
	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
    
	public void guardarObjetos(ArrayList<Object> objects,File nameFile)
    {
        try {
            FileOutputStream is = new FileOutputStream(nameFile);
            ObjectOutputStream ois = new ObjectOutputStream(is);
            for(Object obj: objects)
            {
                ois.writeObject(obj);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	public ArrayList<Object> recuperarObjetos(File name)
	{
		Object obj=null;
		ArrayList<Object> objects = new ArrayList<>() ;
        try {
        	FileInputStream is = new FileInputStream(name);
			ObjectInputStream ois = new ObjectInputStream(is);
			obj = ois.readObject();
			 while (obj!=null)
	            {
				 objects.add(obj);
	                try {
	                	obj = ois.readObject();
	                } catch (Exception ex)
	                {
	                	obj = null;

	                }

	            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
        return objects;
	}

	
	public File getDirectorio() {
		return directorio;
	}

	public File getComponente() {
		return componente;
	}

	public File getCliente() {
		return cliente;
	}

	public File getCombo() {
		return combo;
	}

	public File getFactura() {
		return factura;
	}

	public File getEmpleado() {
		return empleado;
	}

	public static Guardar getGuardar() {
		return guardar;
	}




}
