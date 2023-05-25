package vista;

import java.io.IOException;
import java.util.Scanner;

import utilidad.TratamientoArchivo;
import logica.*;

public class Menu {

	public static void MenuPrincipal() throws IOException, ClassNotFoundException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		
		do {
			System.out.println();
			System.out.println("Menu principal");
			System.out.println("1. Maestras");
			System.out.println("2. Computadores");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					MenuMaestras();
					break;
				
				case 2:
					MenuArmarComputador();
					break;
				
				case 0:
					System.out.println("Gracias por usar nuestros servicios, vuelva");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuMaestras() throws IOException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do {
			System.out.println();
			System.out.println("Menu maestras");
			System.out.println("1. Chasis");
			System.out.println("2. Disco duro");
			System.out.println("3. Tipo computador");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					MenuChasis();
					break;
				
				case 2:
					MenuDiscoDuro();
					break;
					
				case 3:
					MenuTipoComputador();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu principal");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuChasis() throws IOException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		
		do {
			VistaChasis v = new VistaChasis();
			
			System.out.println();
			System.out.println("Menu chasis");
			System.out.println("1. Insertar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Consultar");
			System.out.println("5. Listar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					v.VistaInsertar();
					break;
				
				case 2:
					v.VistaModificar();
					break;
					
				case 3:
					v.VistaEliminar();
					break;
					
				case 4:
					v.VistaBuscar();
					break;
					
				case 5:
					v.VistaListar();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu maestras");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuDiscoDuro() throws IOException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do {
			VistaDiscoDuro v = new VistaDiscoDuro();
			
			System.out.println();
			System.out.println("Menu disco duro");
			System.out.println("1. Insertar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Consultar");
			System.out.println("5. Listar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					v.VistaInsertar();
					break;
				
				case 2:
					v.VistaModificar();
					break;
					
				case 3:
					v.VistaEliminar();
					break;
					
				case 4:
					v.VistaBuscar();
					break;
					
				case 5:
					v.VistaListar();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu maestras");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuTipoComputador() throws IOException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do {
			VistaTipoComputador v = new VistaTipoComputador();
			
			System.out.println();
			System.out.println("Menu tipo computador");
			System.out.println("1. Insertar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Consultar");
			System.out.println("5. Listar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					v.VistaInsertar();
					break;
				
				case 2:
					v.VistaModificar();
					break;
					
				case 3:
					v.VistaEliminar();
					break;
					
				case 4:
					v.VistaBuscar();
					break;
					
				case 5:
					v.VistaListar();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu maestras");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuArmarComputador() throws IOException, ClassNotFoundException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do {
			VistaChasis vc = new VistaChasis();
			VistaDiscoDuro vd = new VistaDiscoDuro();
			VistaTipoComputador vt = new VistaTipoComputador();
			VistaArmarComputador v = new VistaArmarComputador();
			
			System.out.println();
			System.out.println("Menu computadores");
			System.out.println("1. Insertar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Consultar");
			System.out.println("5. Listar");
			System.out.println("6. Serializacion");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					v.VistaInsertar();
					break;
				
				case 2:
					v.VistaModificar();
					break;
					
				case 3:
					v.VistaEliminar();
					break;
					
				case 4:
					v.VistaBuscar();
					break;
					
				case 5:
					v.VistaListar();
					break;
					
				case 6:
					MenuSerializacion();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu principal");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	private static void MenuSerializacion() throws IOException, ClassNotFoundException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do {
			VistaArmarComputador v = new VistaArmarComputador();
			
			System.out.println();
			System.out.println("Menu serializacion");
			System.out.println("1. Serializar");
			System.out.println("2. Deserializar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			datos.nextLine();
			
			switch(opcion) {
				case 1 :
					v.VistaSerializar();
					break;
				
				case 2:
					v.VistaDeserializar();
					break;
				
				case 0:
					System.out.println("Sera llevado al menu computadores");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		} while(opcion != 0);
	}
	
	
}


