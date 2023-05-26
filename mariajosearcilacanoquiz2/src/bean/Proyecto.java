package bean;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.Componentes;

public class Proyecto implements Componentes, Serializable, Comparable<Proyecto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	//private ArrayList<Tarea> tareas;
	private Tarea tarea;
	
	/*public Proyecto(int codigo, ArrayList<Tarea> tareas) {
		this.codigo = codigo;
		this.tareas = tareas;
	}*/
	
	public Proyecto() {}
	
	public Proyecto(int codigo, String nombre, Tarea tarea) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tarea = tarea;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	

	/*public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	@Override
	public String toString() {
		return codigo + " - " + nombre + " - " + tarea.getCodigo();
	}
	
	@Override
	public int compareTo(Proyecto proyecto) {
		return Integer.compare(this.codigo, proyecto.getCodigo());
	}
	
	
}
