package bean;

public class Tarea {

	int codigo;
	String tarea;
	Usuario usuario;
	
	public Tarea() {
		codigo = 0;
		tarea = null;
	}
	
	public Tarea(int codigo, String tarea, Usuario usuario) {
		this.codigo = codigo;
		this.tarea = tarea;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
