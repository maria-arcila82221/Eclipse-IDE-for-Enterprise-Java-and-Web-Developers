package vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bean.*;
import logica.*;
import utilidades.*;

public class VistaProyecto extends LProyecto{

	/*public void VistaInsertar() {
		Scanner pedir = new Scanner(System.in);
		int codigo;
		Tarea tarea = new Tarea();
		
		codigo = super.validarCodigonuevo("Ingrese el codigo: ");
		tarea.setCodigo(super.validarCodigoviejo("Ingrese codigo de tarea a agregar: "));
		
		super.Insertar(codigo, tarea);
	}

	public void VistaModificar() {
		Scanner datos = new Scanner(System.in);
		File f = new File("./datos/DiscoDuro.txt");
		
		if (f.exists()) 
		{
			int modificar = super.validarCodigoviejo("Ingrese el codigo de proyecto a modificar: ");
			
			super.Modificar(modificar);
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}
	
	public void VistaEliminar() {
		Scanner datos = new Scanner(System.in);
		File f = new File("./datos/DiscoDuro.txt");
		
		if (f.exists()) 
		{
			int eliminar = super.validarCodigoviejo("Ingrese el codigo de proyecto a eliminar: ");
			
			super.Eliminar(eliminar);
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}
	
	public void VistaConsultar() {
		Scanner datos = new Scanner(System.in);
		File f = new File("./datos/DiscoDuro.txt");
		
		if (f.exists()) 
		{
			int buscar = super.validarCodigoviejo("Ingrese el codigo de proyecto a consultar: ");
			
			super.Consultar(buscar);
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}
	
	public void VistaListar() {
		File f = new File("./datos/Proyecto.txt");
		
		if (f.exists()) 
		{
			super.Listar();
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}*/
	
	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/Proyectos.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaProyecto() throws IOException {}

	public void VistaInsertar() throws IOException {
		/*VistaUsuario vu = new VistaUsuario();
		vu.VistaInsertar();
		VistaTarea vt = new VistaTarea();
		vt.VistaInsertar();*/
		int codigo;
		String nombre;
		Tarea tarea;
		LTarea ltarea = new LTarea();
		
		if(t.existe(file))
			codigo = validarCodigonuevo("Ingrese nuevo codigo de proyecto: ");
		else {
			System.out.println("Escriba nuevo codigo de proyecto ");
			codigo = datos.nextInt();
			datos.nextLine();
		}

		System.out.println("Escriba el nombre del proyecto: ");
		nombre = datos.nextLine();
		
		if(t.existe("./datos/Tareas.txt"))
			tarea = ltarea.Buscar(validarCodigoviejo("Ingrese codigo de tarea a asignar: "));
		else {
			System.out.println("No existen tareas, por favor vaya y agregue");
			
			return;
		}
		
		Insertar(new Proyecto(codigo, nombre, tarea));
		
		VistaListar();
	}
	
	public void VistaBuscar() {
		if (t.existe(file)) {
			Proyecto pc = Buscar(validarCodigoviejo("Ingrese el codigo de proyecto a buscar: "));
			
			System.out.println(pc);
		} else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaListar() {
		if (t.existe(file)) 
			Listar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaSerializar() throws IOException {
		if (t.existe(file))
			Serializar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaDeserializar() throws ClassNotFoundException, IOException {
		if (t.existe("./datos/ProyectosSerializado.txt"))
			Deserializar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
}
