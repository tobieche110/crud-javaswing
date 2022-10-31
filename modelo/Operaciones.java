package modelo;

import java.util.ArrayList;

//interfaz que posee todas las operaciones de CRUD. Se aplicará a las clases del paquete Controlador
public interface Operaciones {
	
	public boolean insertar(Object obj);
	public boolean eliminar(Object obj);
	public boolean modificar(Object obj);
	
	public ArrayList<Object[]> consultar(); //devuelve arreglo bidimensional con todos los elementos de la tabla
}
