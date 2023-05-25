package vista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import bean.Chasis;
import bean.DiscoDuro;
import logica.*;
import utilidad.TratamientoArchivo;

public class VistaDiscoDuro extends LDiscoDuro{

	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/DiscoDuro.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaDiscoDuro() throws IOException {}
	
	public void VistaInsertar() throws IOException {
		int codigo, capacidad;
		String tipoDisco, interfaz;
		
		if(t.Existe(file))
			codigo = t.validarCodigonuevo(registros, "Ingrese el codigo: ");
		else {
			System.out.println("Ingrese el codigo: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}
		 
		System.out.println("Escriba la capacidad: ");
		capacidad = datos.nextInt();
		datos.nextLine();
		System.out.println("Escriba tipo de disco: ");
		tipoDisco = datos.nextLine();
		System.out.println("Escriba clase de interfaz: ");
		interfaz = datos.nextLine();
		
		Insertar(new DiscoDuro(codigo, capacidad, tipoDisco, interfaz));
	}

	public void VistaModificar() throws IOException {
		if(t.Existe(file)) {
			int codigo = t.validarCodigoviejo(registros, "Ingrese el codigo de disco duro a modificar: ");
			DiscoDuro dd = Buscar(codigo);
			int indice = registros.indexOf(dd);
				
			System.out.println("¿Desea modificar codigo? 1.Si 2.No: ");
			int r = datos.nextInt();
			datos.nextLine();
			if (r == 1)
				dd.setCodigo(t.validarCodigonuevo(registros, "Ingrese nuevo codigo: "));
			
			System.out.println("¿Desea modificar la capacidad? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nueva capacidad: ");
				dd.setCapacidad(datos.nextInt());
				datos.nextLine();
			}
			
			System.out.println("¿Desea modificar el tipo de disco? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nuevo tipo: ");
				dd.setTipoDisco(datos.nextLine());
			}
			
			System.out.println("¿Desea modificar la interfaz? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nueva interfaz: ");
				dd.setInterfaz(datos.nextLine());
			}
			
			t.eliminarArchivo(file);
			Modificar(dd, indice);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaEliminar() throws IOException {
		if(t.Existe(file))
		{
			DiscoDuro dd = Buscar(t.validarCodigoviejo(registros, "Digite el codigo del disco duro a eliminar: "));

			t.eliminarArchivo(file);
			Eliminar(dd);
		}
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaBuscar() {
		if(t.Existe(file)) {
			DiscoDuro dd = Buscar(t.validarCodigoviejo(registros, "Ingrese el codigo de disco duro a buscar: "));
			
			System.out.println(dd);
		}
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaListar() {
		if(t.Existe(file))
			Listar();
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	
}
