package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Buscar {

	public void Buscar() {
		Scanner datos = new Scanner(System.in);
		
		System.out.println("Digite la Cédula del Empleado a buscar");
		int buscar = datos.nextInt();
		ArrayList<String> registrosEmpleados = new ArrayList<String>();
		
		try
		{
			FileReader datosLeidos = new FileReader("C:\\Users\\maria\\Downloads\\mariajosearcilacanoquiz1\\Usuarios.txt");
			BufferedReader bufferdatos = new BufferedReader(datosLeidos);
			String linea = "";
			
			while (linea != null)
			{
				linea = bufferdatos.readLine();
				if(linea != null)
				{
					registrosEmpleados.add(linea);
				}
			}
			
			datosLeidos.close();
			FileWriter archivo = new FileWriter("H:\\Mi unidad\\Tercer semestre\\Bloc de notas\\ArchivoSecuencial.txt");
			BufferedWriter escribir = new BufferedWriter(archivo);
			PrintWriter lineaEmpleado = new PrintWriter(escribir);
			Iterator<String> apuntadorListaEmpleados = registrosEmpleados.iterator();
			
			int wciclo = 1;
			
			while(apuntadorListaEmpleados.hasNext())
			{
				String itemApuntador = apuntadorListaEmpleados.next();
				int ubicacion = itemApuntador.indexOf(",");
				int wcedula = Integer.parseInt(itemApuntador.substring(0,ubicacion));
				
				if(wcedula != buscar)
				{
					lineaEmpleado.append(itemApuntador + "\n");
				}
				else
				{
					System.out.println(lineaEmpleado);
				}
			}
			
			lineaEmpleado.close();
			archivo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
