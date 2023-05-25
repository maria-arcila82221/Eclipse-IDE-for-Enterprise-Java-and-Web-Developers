package logica;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GuardarDatos {

	public String GuardarDatos (int cedula, String nombre, String sexo) {
		String respuesta="";
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./Empleados","rw");
			archivo.seek(archivo.length());
			archivo.writeInt(cedula);
			archivo.writeUTF(nombre);
			archivo.writeUTF(sexo);
			respuesta = "Registro guardado Exitosamente.";
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.print(e);
		}
		
		return respuesta;
	}
}
