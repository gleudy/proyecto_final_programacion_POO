package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Empleado extends Persona implements Serializable{
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private LocalDate fechaIngreso;
	private String cargo;
	private double sueldo;
	public Empleado(String cedula, String nombre, String direccion, String telefono, LocalDate fechaIngreso, String cargo, double sueldo) {
		super(cedula, nombre, direccion, telefono);
		this.cargo = cargo;
		this.fechaIngreso =fechaIngreso;
		this.sueldo = sueldo;
	}
	
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return super.toString()+","+this.fechaIngreso+","+this.cargo+","+this.sueldo;
	}
	
	
	
	




}
