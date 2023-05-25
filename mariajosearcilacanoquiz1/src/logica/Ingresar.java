package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Ingresar {

	public void AñadirUsuario() {
		String nombre = "";
		long identificacion = 0, contraseña = 0;;
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaTerminacion = LocalDate.now();
		String tarea = "";
		byte opcion;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			FileWriter crear = new FileWriter("C:\\Users\\maria\\Downloads\\mariajosearcilacanoquiz1\\Usuarios.txt");

			System.out.println("Digite el nombre");
			nombre = datos.next();
			System.out.println("Digite la contraseña");
			contraseña = datos.nextLong();
			System.out.println("Digite la identificacion");
			identificacion = datos.nextLong();
			BufferedWriter escribir = new BufferedWriter(crear);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(identificacion + nombre + "," + contraseña + "," + "\n");
			linea.close();
			do {
				tarea += "\n";
				System.out.println("Digite la tarea a añadir al usuario");
				tarea = datos.next();
				System.out.println("¿Desea añadir alguna otra tarea? 1.Sí 2.No");
				opcion = datos.nextByte();
			}while(opcion != 2);
			BufferedWriter escribirTareas = new BufferedWriter(crear);
			PrintWriter linea2 = new PrintWriter(escribirTareas);
			linea2.append(tarea + "\n");
			linea2.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*public void AñadirTarea(Long identificacion) {
		String tarea = "";
		byte opcion;
		Scanner datos = new Scanner(System.in);
	
			
			do {
				tarea += "\n";
				System.out.println("Digite la tarea a añadir al usuario");
				tarea = datos.next();
				System.out.println("¿Desea añadir alguna otra tarea? 1.Sí 2.No");
				opcion = datos.nextByte();
			}while(opcion != 2);
			
			BufferedWriter escribir = new BufferedWriter(crear);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(tarea + "\n");
			linea.close();
		}catch(IOException  e) {
			e.printStackTrace();
		}
		
		try
		{
			FileWriter archivo = new FileWriter("H:\\Mi unidad\\Tercer semestre\\Bloc de notas\\ArchivoSecuencial.txt",true);
			String wid;
			BufferedReader datos = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter escribir = new BufferedWriter(archivo);
			PrintWriter linea = new PrintWriter(escribir);
			
			do
			{
				System.out.println("Ingrese la Identificación, cero(0) para terminar");
				wid = datos.readLine();
				System.out.println(wid);
				
				if(!wid.equals("0"))
				{
					linea.append(wid + "\n");
				}
			}
			while(!wid.equals("0"));
			
			linea.close();
		}
		catch(IOException e) 
		{
			
		}
	}
	
	public void CambiarNombreArchivo(Long identificacion) {
		String s = "";
		
		s = "C:\\Users\\maria\\Downloads\\mariajosearcilacanoquiz1\\" + identificacion + ".txt";
		
		File oldfile = new File("C:\\Users\\maria\\Downloads\\mariajosearcilacanoquiz1\\TareasUsuarios.txt");
        File newfile = new File("/home/decodigo/Documentos/java/archivos/archivoNuevo.txt");
        if (oldfile.renameTo(newfile)) {
            System.out.println("archivo renombrado");
        } else {
            System.out.println("error");
        }
	}
	
	public boolean Buscar(FileWriter crearTareas) {
		String linea = "";
		String identificacion;
		Scanner datos = new Scanner(System.in);
		
		System.out.println("Ingrese identificación");
		identificacion = datos.nextLine();
		
		BufferedReader br=new BufferedReader(new FileReader(crearTareas));
		
		while ((linea= br.readLine())!=null) {

            if(linea.equalsIgnoreCase(identificacion)) {
                return true;

                /*for(int i=0;i<2;i++) {
                    System.out.println(br.readLine());
                }   
                break;

            }else {
                System.out.println("El usuario no existe");

                break;
            }

        }
	}*/
}
