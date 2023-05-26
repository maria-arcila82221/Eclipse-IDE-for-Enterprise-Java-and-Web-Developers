package vista;

import java.io.IOException;
import java.util.Scanner;

import bean.*;
import logica.LUsuario;
import utilidades.*;

public class VistaUsuario extends LUsuario {

	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/Usuarios.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaUsuario() throws IOException {}
	
	public void VistaInsertar() throws IOException {
		int codigo;
		String nombre;
		
		if(t.existe(file))
			codigo = validarCodigonuevo("Ingrese el codigo nuevo codigo de usuario: ");
		else {
			System.out.println("Escriba el nuevo codigo de usuario: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}

		System.out.println("Escriba el nombre: ");
		nombre = datos.nextLine();
		
		Insertar(new Usuario(codigo, nombre));
	}
	
}
