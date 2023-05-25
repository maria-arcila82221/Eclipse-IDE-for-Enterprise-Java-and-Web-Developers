package vista;

import java.util.Scanner;

public class Menu {

	public static void MenuPrincipal() {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do 
		{
			System.out.println("Gestion de proyectos");
			System.out.println("1. Ingresar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			
			switch(opcion)
			{
				case 1 :
					MenuVistaProyecto();
					break;
				
				case 0:
					System.out.println("Gracias por usar nuestros servicios, vuelva");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		}
		while(opcion != 0);
	}
	
	private static void MenuVistaProyecto() {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		VistaProyecto v = new VistaProyecto();
		 
		do 
		{
			System.out.println("Menu proyecto"
					+ "");
			System.out.println("1. Insertar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Consultar");
			System.out.println("5. Listar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			
			switch(opcion)
			{
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
					v.VistaConsultar();
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
		}
		while(opcion != 0);
	}
	
}
