package logico;

import java.util.ArrayList;

public class Factura {
	private ArrayList<Componente> componentes;
	private ArrayList<Combo>combos;
	public Factura() {
		componentes = new ArrayList<Componente>();
		combos = new ArrayList<Combo>();
	}
	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}
	public void agregarCombo(Combo combo) {
		combos.add(combo);
		
		
	}
	
	//Aqui puede ir el metodo del examen para listar los productos con su precio
	
    public double precioTotal() {
        double precioTotal = 0.0;
        double precioTotalCombo = 0.0;
        for (Componente componente : componentes) {
            precioTotal += componente.getPrecio();
        }
        for (Combo combo : combos) {
        	precioTotalCombo += combo.precioOferta();
        }
        
        return precioTotal + precioTotalCombo;
    }
}
