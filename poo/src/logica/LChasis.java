package logica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.*;
import bean.*;
import interfaces.ICrud;
import utilidad.TratamientoArchivo;

public class LChasis implements ICrud<Chasis> {
	
	public ArrayList<Chasis> registros = new ArrayList<>();
	private String file = "./datos/Chasis.txt";

	public LChasis() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.Existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(Chasis chasis) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(chasis.getCodigo());
		archivo.writeInt(chasis.getRanuras());
		archivo.writeBoolean(chasis.getAdminCables());
		archivo.writeUTF(chasis.getModelo());
		archivo.close();
	}
	
	public void Modificar(Chasis chasis, int indice) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		int c = 0;
		
		archivo.seek(0);
		
		for(Chasis chasisAuxiliar : registros) {
			if(c == indice) {
				registros.add(indice, chasis);
				registros.remove(indice + 1);
				archivo.writeInt(chasis.getCodigo());
				archivo.writeInt(chasis.getRanuras());
				archivo.writeBoolean(chasis.getAdminCables());
				archivo.writeUTF(chasis.getModelo());
			} else {
				archivo.writeInt(chasisAuxiliar.getCodigo());
				archivo.writeInt(chasisAuxiliar.getRanuras());
				archivo.writeBoolean(chasisAuxiliar.getAdminCables());
				archivo.writeUTF(chasisAuxiliar.getModelo());
			}
			
			c++;
		}
		
		archivo.close();
	}

	public void Eliminar(Chasis chasis) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(0);
		registros.remove(chasis);
		
		for(Chasis chasisAuxiliar : registros) {
			archivo.writeInt(chasisAuxiliar.getCodigo());
			archivo.writeInt(chasisAuxiliar.getRanuras());
			archivo.writeBoolean(chasisAuxiliar.getAdminCables());
			archivo.writeUTF(chasisAuxiliar.getModelo());
		}
		
		archivo.close();
	}
	
	public Chasis Buscar(int buscar) {
		for(Chasis chasis : registros) {
			if(chasis.getCodigo() == buscar)
				return chasis;
		}
		
		return null;
	}
	
	public void Listar() {
		for(Chasis chasis : registros)
			System.out.println(chasis);
	}
	
	public ArrayList<Chasis> archivoAarrayList() throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new Chasis(archivo.readInt(), archivo.readInt(), archivo.readBoolean(), archivo.readUTF()));
		
		archivo.close();
		
		return registros;
	}
	
	/*public void Listar() {
		String wcadena = "";

		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Chasis.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				wcadena = archivo.readInt() + " - ";
				wcadena += archivo.readInt() + " - ";
				wcadena += archivo.readBoolean() + " - ";
				wcadena += archivo.readUTF();
				
				System.out.println(wcadena);
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.print(e);
			System.out.println("Ocurrio un error");
		}
	}*/
	
	/*public int validarCodigonuevo(String t){ //no exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Chasis.txt","r");
			
			do
			{
				System.out.println(t);
				codigo = datos.nextInt();
				datos.nextLine();
				
				archivo.seek(0);
				
				while(archivo.getFilePointer() < archivo.length())
				{
					int pos = archivo.readInt();
					
					archivo.readInt();
					archivo.readBoolean();
					archivo.readUTF();
					
					if(pos == codigo)
					{
						System.out.println("Ingrese un codigo no existente");
						
						codigo = -1;
						
						archivo.seek(archivo.length());
					}
				}
			}
			while(codigo == -1);
		}
		catch(IOException e) 
		{
			System.out.println(e);
			System.out.println("Ocurrio un error");
		}
		
		return codigo;
    }*/
	
	/*public int validarCodigonuevo(String t){ //no exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
			
		do
		{
			Iterator<Chasis> apuntadorLista = registros.iterator();
			
			System.out.println(t);
			codigo = datos.nextInt();
			datos.nextLine();
			
			while(apuntadorLista.hasNext())
			{
				Chasis chasis = apuntadorLista.next();
				
				if(chasis.getCodigo() == codigo)
				{
					System.out.println("Ingrese un codigo no existente");
					
					codigo = -1;
					
					break;
				}
			}
		}
		while(codigo == -1);
		
		return codigo;
    }
	
	/*public int validarCodigoviejo(String t){ //exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Chasis.txt","r");
			
			do
			{
				System.out.println(t);
				codigo = datos.nextInt();
				datos.nextLine();
				
				archivo.seek(0);
				
				while(archivo.getFilePointer() < archivo.length())
				{
					int pos = archivo.readInt();
					
					archivo.readInt();
					archivo.readBoolean();
					archivo.readUTF();
					
					if((pos!=codigo) && (archivo.getFilePointer()==archivo.length()))
					{
						System.out.println("El codigo no existe, inserte otro");
						
						codigo = -1;
						
						archivo.seek(archivo.length());
					}
				}
			}
			while(codigo == -1);
		}
		catch(IOException e) 
		{
			System.out.println(e);
			System.out.println("Ocurrio un error");
		}
		
		return codigo;
    }*/
	
	/*public int validarCodigoviejo(String t){ //exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);

		do
		{
			Iterator<Chasis> apuntadorLista = registros.iterator();
			
			System.out.println(t);
			codigo = datos.nextInt();
			datos.nextLine();
			
			while(apuntadorLista.hasNext())
			{
				Chasis chasis = apuntadorLista.next();
				
				if (chasis.getCodigo() == codigo) 
				{
			        break;
			    }

			    if (!apuntadorLista.hasNext() && chasis.getCodigo()!=codigo) 
			    {
			        System.out.println("El código no existe, inserte otro");
			        
			        codigo = -1;
			    }
			}
		}
		while(codigo == -1);
		
		return codigo;
    }
	
	public void eliminarArchivo() {
		File f = new File("./datos/Chasis.txt");
		
		if (!f.delete())
		{
			System.out.println("El fichero no se pudo borrar");
		}
	}
	
	public void insertarNodo(int indice, Chasis chasis) {
		registros.add(indice, chasis);
		registros.remove(indice+1);
	}*/

}

/* 

	Modelo Alto Ancho Profundidad Org ...
 1 	ATX  15cm 15cm     20cm      S     <-- Tienen que seleccionar de aqui, guardan el codigo y eso es lo que se muestra por pantalla
 2 	ITX
 ^
 |-codigo 
 
	Archivo Datos
	 - Todos los chasis
	Archivo datos
	 - Discos duros
	Archivo datos
	 - lo que sea
	 
	 
1. Maestras --> 1. Chasis
				2. Discoduro
2. Armar computador --> 1. 1021
					2. 1022
					3. 1023

----------------------------------------------------------------------------------
										|
										|
										|
										^
								Logica de negocio
								
Chasis
	1 ATX 15 25 32 S |
	2 ITX 25 30 30 N |--> Informacion en archivo de datos, cada chasis es identificado con un codigo
	
Computador
	1020 1 |
	1021 2 |--> el computador 102# con un chasis #
	1022 1 |
	
Maestras --> se puede registrar un nuevo chasis, pero

...Crear PC
	Seleccione un chasis
	1. ATX..   
	2. ITX..
	Seleccione disco duro     --> 1020 1 1
	1. Mecanico..				  1021 2 1
	2. Solido..                   1022 1 2

*/
