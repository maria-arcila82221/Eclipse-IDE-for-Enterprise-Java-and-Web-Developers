package vista;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void MenuPrincipal() throws IOException, ClassNotFoundException {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		 
		do 
		{
			VistaProyecto v = new VistaProyecto();
			
			System.out.println("Gestion de proyectos");
			System.out.println("1. Ingresar");
			System.out.println("2. Listar Serializados");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			
			switch(opcion)
			{
				case 1 :
					VistaUsuario vu = new VistaUsuario();
					vu.VistaInsertar();
					VistaTarea vt = new VistaTarea();
					vt.VistaInsertar();
					v.VistaInsertar();
					v.VistaSerializar();
					break;
					
				case 2 :
					v.VistaDeserializar();
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
	
	
}
