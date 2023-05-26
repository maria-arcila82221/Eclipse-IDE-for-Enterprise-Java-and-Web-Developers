package vista;

import java.io.IOException;
import java.util.Scanner;

import bean.*;
import logica.*;
import utilidades.TratamientoArchivo;

public class VistaTarea extends LTarea {

	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/Tareas.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaTarea() throws IOException {}
	
	public void VistaInsertar() throws IOException {
		int codigo;
		String tarea;
		Usuario usuario;
		LUsuario lusuario = new LUsuario();
		
		if(t.existe(file))
			codigo = validarCodigonuevo("Ingrese el codigo: ");
		else {
			System.out.println("Ingrese el nuevo codigo de tarea: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}
		
		System.out.println("Ingrese la tarea: ");
		tarea = datos.nextLine();
		
		if(t.existe("./datos/Usuarios.txt"))
			usuario = lusuario.Buscar(lusuario.validarCodigoviejo("Ingrese codigo de usuario a asignar: "));
		else {
			System.out.println("No existen usuarios, por favor vaya y agregue");
			
			return;
		}
		
		Insertar(new Tarea(codigo, tarea, usuario));
	}
	
}
