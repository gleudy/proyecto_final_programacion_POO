package logico;

import java.util.Date;

public class Empleado extends Persona{
	Date fechaIngreso;
	String cargo;
	double sueldo;
	public Empleado(String cedula, String nombre, String direccion, String telefono, Date fechaIngreso, String cargo, double sueldo) {
		super(cedula, nombre, direccion, telefono);
		this.cargo = cargo;
		this.fechaIngreso =fechaIngreso;
		this.sueldo = sueldo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
