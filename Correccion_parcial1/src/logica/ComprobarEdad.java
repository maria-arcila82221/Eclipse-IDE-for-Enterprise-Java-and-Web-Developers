package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.Period;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ComprobarEdad {

	public ComprobarEdad(LocalDate fechaNacimiento){
		char Vc[];
		
		try
		{
			FileReader archivoSecuencial = new FileReader("src/datos/fechaNacimiento.txt");
			BufferedReader bufferdatos = new BufferedReader(archivoSecuencial);
			String linea = bufferdatos.readLine();//no hay que volverlo a leer, manipula la variable
			
			RandomAccessFile archivoAleatorio = new RandomAccessFile("./datos/Iteracion.txt","rw");
			
			Vc = linea.toCharArray();
			
			int numeroAleatorio = (int)(Math.random()*9);
			char numero = Integer.toString(numeroAleatorio).charAt(0);
			archivoAleatorio.seek(archivoAleatorio.length());//refundelo
			
			int ciclo = 0;
			while (Vc[6] != numero)
			{
				archivoAleatorio.writeUTF("ciclo: " + ciclo + ", " + numeroAleatorio + " aleatorio\n");
				numeroAleatorio = (int)(Math.random()*9);
				numero = Integer.toString(numeroAleatorio).charAt(0);
				ciclo++;
			}
			
			LocalDate hoy = LocalDate.now();
			Period periodo = Period.between(fechaNacimiento, hoy);
			archivoAleatorio.writeUTF("ciclo: " + ciclo + ", " + periodo.getYears() + " es tu edad\n");

			archivoAleatorio.close();
			archivoSecuencial.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
