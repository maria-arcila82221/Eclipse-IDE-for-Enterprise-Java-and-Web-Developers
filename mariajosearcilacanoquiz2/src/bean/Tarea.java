package bean;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.Componentes;

public class Tarea implements Componentes, Serializable, Comparable<Tarea> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String tarea;
	//private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
	public Tarea() {}
	
	/*public Tarea(int codigo, String tarea, ArrayList<Usuario> usuarios) {
		this.codigo = codigo;
		this.tarea = tarea;
		this.usuarios = usuarios;
	}*/
	
	public Tarea(int codigo, String tarea, Usuario usuario) {
		this.codigo = codigo;
		this.tarea = tarea;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	/*public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return codigo + " - " + tarea + " - " + usuario.getCodigo();
	}
	
	@Override
	public int compareTo(Tarea tarea) {
		return Integer.compare(this.codigo, tarea.getCodigo());
	}

	
}
