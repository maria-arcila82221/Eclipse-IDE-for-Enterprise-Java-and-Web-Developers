package utilidad;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import bean.Chasis;
import interfaces.Componentes;

public class TratamientoArchivo {

	public TratamientoArchivo() {}
	
	public boolean Existe(String t) {
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
	
	public <T extends Componentes> int validarCodigonuevo(ArrayList<T> registros, String t){ //no exista
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
	
	public <T extends Componentes & Comparable<T>> ArrayList<T> ordenarCodigos(ArrayList<T> registros) {
	    Collections.sort(registros);
	    
	    return registros;
	}
	
	/*public <T> ArrayList<T> insertarNodo(ArrayList<T> registros, int indice, T objeto) {
		registros.add(indice, objeto);
		registros.remove(indice+1);
		
		return registros;
	}*/
	
	
}
