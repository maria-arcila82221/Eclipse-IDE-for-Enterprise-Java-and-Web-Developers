package bean;

import java.io.Serializable;
import java.time.LocalDate;

import interfaces.Componentes;

public class Usuario implements Componentes, Serializable, Comparable<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo; //el codigo viene a ser el nombre de usuario
	private String nombre;
	
	public Usuario() {
		codigo = 0;
		nombre = "";
	}
	
	public Usuario(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return codigo + " - " + nombre;
	}
	
	@Override
	public int compareTo(Usuario usuario) {
		return Integer.compare(this.codigo, usuario.getCodigo());
	}
	
}
