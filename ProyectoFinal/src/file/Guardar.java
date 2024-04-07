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

		try {
			componente.createNewFile();
			return true;
	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
    
	public void guardarComponentes(ArrayList<Componente> componentes)
    {
        try {
            FileOutputStream is = new FileOutputStream(componente);
            ObjectOutputStream ois = new ObjectOutputStream(is);
            for(Componente comp: componentes)
            {
                ois.writeObject(comp);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	public void guardarComponentes1(Componente comp)
    {
        try {
            FileOutputStream is = new FileOutputStream(componente);
            ObjectOutputStream ois = new ObjectOutputStream(is);
            ois.writeObject(comp);
            ois.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Componente recuperarComponentes() throws FileNotFoundException
	{
		Componente comp = null;
        try {
        	FileInputStream is = new FileInputStream(componente);
			ObjectInputStream ois = new ObjectInputStream(is);
			comp = (Componente) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
        return comp;
	}
}
