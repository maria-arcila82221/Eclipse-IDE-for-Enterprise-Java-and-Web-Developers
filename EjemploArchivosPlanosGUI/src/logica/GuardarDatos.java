package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class GuardarDatos {

	public GuardarDatos(int cedula, String nombre, Long salario, LocalDate fechaNacimiento) {
		
		try 
		{
			FileWriter archivo = new FileWriter("./Empleados.txt",true);
			BufferedWriter escribir = new BufferedWriter(archivo);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(cedula + "," + nombre + "," + salario + "," + fechaNacimiento + "\n");
			linea.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en los datos");
		}
	}

}
