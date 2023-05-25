package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import logica.ComprobarEdad;

public class Inicio {

	public static void main(String[] args) {
		
		try
		{
			FileReader archivo = new FileReader("src/datos/fechaNacimiento.txt");//Apuntador
			BufferedReader bufferdatos = new BufferedReader(archivo);//canal de comunicacion
			
			String linea = bufferdatos.readLine();
			
			ComprobarEdad comprobar = new ComprobarEdad(LocalDate.parse(linea));//mandar solo localdate o string ya por alla manipulo
			
			archivo.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
