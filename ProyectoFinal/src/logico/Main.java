package logico;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


import file.Guardar;

public class Main {

	public static void main(String[] args) {

		Tienda miTienda;
		miTienda = Tienda.getInstance();
		
		Componente disco = new Disco("001",12.6,10,"Kinstom","estandar",256,"Sata");
		Componente micro = new Micro("001",12.6,10,"Kinstom","estandar","socket 7",2600);
		Componente motherB = new MotherBoard("001",12.6,10,"Kinstom","estandar","estandar","estadar","estadar");
		Componente ram = new Ram("001",12.6,10,"Kinstom",8,"ddr3");
		
		miTienda.agregarComponente(disco);
		miTienda.agregarComponente(micro);
		miTienda.agregarComponente(motherB);
		miTienda.agregarComponente(ram);
		
		Cliente c1 = new Cliente("0001", "Miguel Paulino","Mi Casa","809","VIP");
		Cliente c2 = new Cliente("0002", "Gleudy Gomez","Europa","829","Arraca Vaca");
		Cliente c3 = new Cliente("0003", "Enmanuel Gimenez","Usa","849","Normal");
		
		miTienda.agregarCliente(c1);
		miTienda.agregarCliente(c2);
		miTienda.agregarCliente(c3);
		
		
		Empleado e1 = new Empleado("0004", "Enmanuel Gimenez","Usa","849",LocalDate.of(2021, 4, 4),"Gerente",55000);
		Empleado e2 = new Empleado("0005", "Gleudy Gomez","Usa","829",LocalDate.of(2020, 4, 4),"Supervidor",10000);
		Empleado e3 = new Empleado("0006", "Miguel Paulinoz","Mi casa","809",LocalDate.of(2022, 4, 4),"Cajero",5000);
		
		miTienda.agregarEmpleado(e1);
		miTienda.agregarEmpleado(e2);
		miTienda.agregarEmpleado(e3);
		
		Factura f1 = new Factura("0001","0004");
		f1.agregarComponente(ram);
		f1.agregarComponente(motherB);
		
		

		Combo cb1 = new Combo();
		cb1.agregarComponete(ram);
		cb1.agregarComponete(micro);
		cb1.agregarComponete(motherB);
		
		miTienda.agregarCombo(cb1);
		
		f1.agregarCombo(cb1);
		
		miTienda.agregarFactura(f1);
		
		ArrayList<Cliente> misClientes = miTienda.getClientes();
		
		for(Cliente cl: misClientes)
		{
			System.out.println(cl);
		}
		ArrayList<Componente> misComconestes = miTienda.getComponentes();
		
		System.out.println("\n\n");
		
		for(Componente cp: misComconestes)
		{
			System.out.println(cp);
		}
		
	}

}
 