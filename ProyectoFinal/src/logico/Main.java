package logico;

import java.util.ArrayList;

import file.ClaseArchivo;

public class Main {

	public static void main(String[] args) {
		ArrayList<Componente> componentes = new ArrayList();
		ClaseArchivo archivo =  new ClaseArchivo();
		Tienda t = null;
		t.getInstance();
		
		Componente disco = new Disco("001",12.6,10,"Kinstom","estandar",256,"Sata");
		Componente micro = new Micro("001",12.6,10,"Kinstom","estandar","socket 7",2600);
		Componente motherB = new MotherBoard("001",12.6,10,"Kinstom","estandar","estandar","estadar","estadar");
		Componente ram = new Ram("001",12.6,10,"Kinstom",8,"ddr3");
		
		t.agregarComponente(disco);
		t.agregarComponente(micro);
		t.agregarComponente(motherB);
		t.agregarComponente(ram);
		componentes=t.getComponentes();
		
		
		
		int a =0;
		
		
		
		
		
		
				
				
	}

}
