package modelo;

import java.util.ArrayList;

import dao.DAOalumno;

//representa la tabla de la BDD
public class alumno {
	
	private int legajo;
	private String apellido;
	private String nombre;
	private int anioIngreso;
	public DAOalumno dao;
	
	//Constructor
	public alumno() {
		this.dao = new DAOalumno();
	}
	
	public alumno(int legajo, String apellido, String nombre, int anioIngreso) {
		this.legajo = legajo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.anioIngreso = anioIngreso;
	}
	
	//SETTERS
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}
	
	//GETTERS
	public int getLegajo() {
		return legajo;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getAnioIngreso() {
		return anioIngreso;
	}
	
	
	public ArrayList<Object[]> consultarDAO(){
		return this.dao.consultar();
	}
	
	public boolean modificarDAO(Object obj) {
		return this.dao.modificar(obj);
	}
	
	public boolean insertarDAO(Object obj) {
		return this.dao.insertar(obj);
	}
	
	public boolean eliminarDAO(Object obj) {
		return this.dao.eliminar(obj);
	}
}
