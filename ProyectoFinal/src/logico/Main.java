package logico;

import java.util.ArrayList;

import file.ClaseArchivo;

public class Main {

	public static void main(String[] args) {
		ArrayList<Componente> componentes = new ArrayList();
		ArrayList<Cliente> clientes = new ArrayList();
		ClaseArchivo archivo =  new ClaseArchivo();
		Tienda t = null;
		t = Tienda.getInstance();
		
		Componente disco = new Disco("001",12.6,10,"Kinstom","estandar",256,"Sata");
		Componente micro = new Micro("001",12.6,10,"Kinstom","estandar","socket 7",2600);
		Componente motherB = new MotherBoard("001",12.6,10,"Kinstom","estandar","estandar","estadar","estadar");
		Componente ram = new Ram("001",12.6,10,"Kinstom",8,"ddr3");
		
		t.agregarComponente(disco);
		t.agregarComponente(micro);
		t.agregarComponente(motherB);
		t.agregarComponente(ram);
		componentes=t.getComponentes();
		
		Cliente c1 = new Cliente(001,"Su casa");
		Cliente c2 = new Cliente(002,"Su casa");
		
		t.agregarCliente(c1);
		t.agregarCliente(c2);
		
		clientes = t.getClientes();
		
		int a =0;
		
		
		
		
		
		
				
				
	}

}
