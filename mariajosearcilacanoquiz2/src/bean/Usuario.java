package bean;

import java.time.LocalDate;

public class Usuario {

	int codigo; //el codigo viene a ser el nombre de usuario
	String nombre;
	
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
	
}
