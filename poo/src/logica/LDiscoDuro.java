package logica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import interfaces.ICrud;
import utilidad.TratamientoArchivo;

public class LDiscoDuro implements ICrud<DiscoDuro> {
	
	public ArrayList<DiscoDuro> registros = new ArrayList<>();
	private String file = "./datos/DiscoDuro.txt";
	
	public LDiscoDuro() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.Existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(DiscoDuro dd) throws IOException {
			RandomAccessFile archivo = new RandomAccessFile(file,"rw");
			
			archivo.seek(archivo.length());
			archivo.writeInt(dd.getCodigo());
			archivo.writeInt(dd.getCapacidad());
			archivo.writeUTF(dd.getTipoDisco());
			archivo.writeUTF(dd.getInterfaz());
			archivo.close();
	}
	
	public void Modificar(DiscoDuro dd, int indice) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		int c = 0;
		
		archivo.seek(0);
		
		for(DiscoDuro ddAuxiliar : registros)
		{
			if(c == indice) {
				registros.add(indice, dd);
				registros.remove(indice + 1);
				archivo.writeInt(dd.getCodigo());
				archivo.writeInt(dd.getCapacidad());
				archivo.writeUTF(dd.getTipoDisco());
				archivo.writeUTF(dd.getInterfaz());
			} else {
				archivo.writeInt(ddAuxiliar.getCodigo());
				archivo.writeInt(ddAuxiliar.getCapacidad());
				archivo.writeUTF(ddAuxiliar.getTipoDisco());
				archivo.writeUTF(ddAuxiliar.getInterfaz());
			}
			
			c++;
		}
		
		archivo.close();
	}
	
	public void Eliminar(DiscoDuro dd) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(0);
		registros.remove(dd);
		
		for(DiscoDuro ddAuxiliar : registros)
		{
			archivo.writeInt(ddAuxiliar.getCodigo());
			archivo.writeInt(ddAuxiliar.getCapacidad());
			archivo.writeUTF(ddAuxiliar.getTipoDisco());
			archivo.writeUTF(ddAuxiliar.getInterfaz());
		}
		
		archivo.close();
	}
	
	public DiscoDuro Buscar(int buscar) {
		for(DiscoDuro dd : registros) {
			if(dd.getCodigo() == buscar)
				return dd;
		}
		
		return null;
	}
	
	public void Listar() {
		for(DiscoDuro dd : registros)
			System.out.println(dd);
	}
	
	public ArrayList<DiscoDuro> archivoAarrayList() throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new DiscoDuro(archivo.readInt(), archivo.readInt(), archivo.readUTF(), archivo.readUTF()));
		
		archivo.close();
		
		return registros;
	}
	
	/*public void Listar() {
		String wcadena = "";

		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/DiscoDuro.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				wcadena = archivo.readInt() + " - ";
				wcadena += archivo.readInt() + " - ";
				wcadena += archivo.readUTF() + " - ";
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
	
	/*public int validarCodigonuevo(String t){
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/DiscoDuro.txt","r");
			
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
					archivo.readUTF();
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
	
	/*public int validarCodigoviejo(String t){ //exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/DiscoDuro.txt","r");
			
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
					archivo.readUTF();
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
	
	
}
