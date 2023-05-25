package vista;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import logica.*;
import bean.*;
import utilidad.*;

public class VistaSecuencialF extends SecuencialF {

	private TratamientoArchivo t = new TratamientoArchivo();
	private String oldFile = "./datos/SecuencialF.txt";
	private String newFile = "./datos/SecuencialFAuxiliar.txt";
	private Scanner datos = new Scanner(System.in);
	
	public void VistaInsertar() throws IOException {
		int cedula = 0;
		String nombre = "";
		
		if(t.Existe(oldFile))
			cedula = validarCedulanueva("Ingrese la cedula: ");
		else {
			System.out.println("Digite la Cédula: ");
			cedula = datos.nextInt();
			datos.nextLine();
		}
		
		System.out.println("Digite el Nombre: ");
		nombre = datos.nextLine();
		
		Insertar(cedula + nombre + "\n");
	}
	
	public void VistaModificar() throws IOException {
		if (t.Existe(oldFile)) 
		{
			int modificar = validarCedulavieja("Ingrese cedula de usuario a modificar datos: ");
			String s = Buscar(modificar);
			
			System.out.println("¿Desea modificar cedula? 1.Si 2.No: ");
			int r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				int cedula = validarCedulanueva("Ingrese nueva cedula: ");
				s = cedula + s.split(",")[1];
			}
			
			System.out.println("¿Desea modificar el nombre? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nuevo nombre: ");
				String nombre = datos.nextLine();
				s = s.split(",")[0] + nombre;
			}

			Modificar(s, modificar);
			t.eliminarYrenombrarArchivo(oldFile, newFile);
		}
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaEliminar() throws IOException {
		if (t.Existe(oldFile)) 
		{
			String s = Buscar(validarCedulavieja("Ingrese cedula de usuario a eliminar: "));
			Eliminar(s);
			t.eliminarYrenombrarArchivo(oldFile, newFile);
		}
		else
			System.out.println("No existe archivo");
	}
	
	public void VistaBuscar() throws IOException {
		if (t.Existe(oldFile)) {
			String s = Buscar(validarCedulavieja("Ingrese la cedula de usuario a buscar: "));
			
			System.out.println(s);		
		}
		else
			System.out.println("No existe archivo");
	}
	
	public void VistaListar() throws IOException {
		if (t.Existe(oldFile)) 
			Listar();
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	
}
