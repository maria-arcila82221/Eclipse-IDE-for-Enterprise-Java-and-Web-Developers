package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import interfaces.*;

public class TratamientoArchivo {

	public TratamientoArchivo() {}
	
	public boolean existe(String t) {
		boolean b = false;
		File f = new File(t);
		
		if (f.exists() && f.length()!=0) 
			b = true;

		return b;
	}
	
	public void eliminarArchivo(String t) {
		File f = new File(t);
		
		if (!f.delete())
			System.out.println("El fichero no se pudo borrar");
	}
	
	public void renombrarArchivo(String dOld, String dNew) {
		File newFile = new File(dOld);
		File oldFile = new File(dNew);
		
		if (!oldFile.renameTo(newFile)) 
			System.out.println("Error, puede que halla un archivo con el mismo nombre");
	}
	
	public int numeroRegistrossecuencial(String d) throws IOException {
		FileReader archivo = new FileReader(d);
		BufferedReader leer = new BufferedReader(archivo);
		String s = "";
		int c = 0;
		
		while ((s=leer.readLine()) != null) {
				c++;
		}
		
		archivo.close();
		
		return c;
	}
	
	public int numeroRegistrosaleatorio(String d) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(d,"r");
		int c = 0;
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length()) {
			archivo.readInt();
			archivo.readUTF();
			
			c++;
		}
		
		archivo.close();
		
		return c;
	}
	
	public <T extends Componentes & Comparable<T>> ArrayList<T> ordenarCodigos(ArrayList<T> registros) {
	    Collections.sort(registros);
	    
	    return registros;
	}
	
	/*public <T extends Componentes> int validarCodigonuevo(ArrayList<T> registros, String t){ //no exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
			
		do {
			Iterator<T> apuntadorLista = registros.iterator();
			
			System.out.println(t);
			codigo = datos.nextInt();
			datos.nextLine();
			
			while(apuntadorLista.hasNext()) {
				T objeto = apuntadorLista.next();
				
				if(objeto.getCodigo()==codigo || codigo<=0) {
					System.out.println("Ingrese un codigo no existente o diferente de cero o no negativo");
					
					codigo = -1;
					
					break;
				}
			}
		} while(codigo == -1);
		
		return codigo;
    }
	
	public <T extends Componentes> int validarCodigoviejo(ArrayList<T> registros, String t){ //exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);

		do {
			Iterator<T> apuntadorLista = registros.iterator();
			
			System.out.println(t);
			codigo = datos.nextInt();
			datos.nextLine();
			
			while(apuntadorLista.hasNext()) {
				T objeto = apuntadorLista.next();
				
				if (objeto.getCodigo() == codigo) 
			        break;

			    if (!apuntadorLista.hasNext()) {
			        System.out.println("El código no existe, inserte otro");
			        
			        codigo = -1;
			    }
			}
		} while(codigo == -1);
		
		return codigo;
    }
	
	/*public <T> ArrayList<T> insertarNodo(ArrayList<T> registros, int indice, T objeto) {
		registros.add(indice, objeto);
		registros.remove(indice+1);
		
		return registros;
	}*/
	
	
}
