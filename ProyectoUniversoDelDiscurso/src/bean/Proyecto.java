package bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private LocalDate inicio;
	private LocalDate fin;
	private Estado estado;
	private ArrayList<Tarea> tareas;
	
}

/*public class Proyecto {

	private String nombre;
	private String descripcion;
	private LocalDate inicio;
	private LocalDate fin;
	private String estado;//en progreso, completado, cancelado
	//private Tarea tarea;//lista de tareas asociadas al proyecto
	private ArrayList<Tarea> tareas;
	private Usuario responsable;

}*/

//archivo secuencial: datos como la descripcion de la tarea o el estado
//archivo aleatorio: para poder acceder a las cosas mediante indices o claves
//archivo serializado: datos de las entidades serializadas(en este caso proyecto)

//la serializacion sirve para compactar y asi facilitar su envio a traves de algun medio


//el border layout divide la pantalla en 5 partes