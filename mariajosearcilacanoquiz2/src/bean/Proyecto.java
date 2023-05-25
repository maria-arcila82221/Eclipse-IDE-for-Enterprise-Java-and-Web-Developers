package bean;

public class Proyecto {

	int codigo;
	Tarea tarea;
	
	public Proyecto(int codigo, Tarea tarea) {
		this.codigo = codigo;
		this.tarea = tarea;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
