package vista;

import java.util.Scanner;

import logica.Buscar;
import logica.Ingresar;

public class Menu {

	public void MenuPrincipal() {
		Scanner datos = new Scanner(System.in);
		int opcion = -1;
		Ingresar i = new Ingresar();
		Buscar b = new Buscar();
		
		do 
		{
			System.out.println("Aplicación de Gestión de Tareas");
			System.out.println("Menú Principal");
			System.out.println("1. Ingresar");
			System.out.println("2. Buscar");
			System.out.println("0. Salir");
			System.out.println("Digite la opción deseada: ");

			opcion = datos.nextInt();
			
			switch(opcion)
			{
				case 1 :
					i.AñadirUsuario();
					break;
				
				case 2:
					b.Buscar();
					break;
				
				case 0:
					System.out.println("Gracias por usar nuestros servicios, vuelva");
					break;
				
				default :
					System.out.println("Opción no Valida");
					break;
			}
		}while(opcion != 0);
	}
	
}
