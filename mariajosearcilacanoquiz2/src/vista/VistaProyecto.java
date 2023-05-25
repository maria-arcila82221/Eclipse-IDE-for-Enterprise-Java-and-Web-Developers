package vista;

import java.io.File;
import java.util.Scanner;

import bean.*;
import logica.*;

public class VistaProyecto extends LProyecto{

	public void VistaInsertar() {
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
	}
	
}
