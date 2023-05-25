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

public class LTipoComputador implements ICrud<TipoComputador> {
	
	public ArrayList<TipoComputador> registros = new ArrayList<>();
	private String file = "./datos/TipoComputador.txt";
	
	public LTipoComputador() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.Existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(TipoComputador tipo) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(tipo.getCodigo());
		archivo.writeUTF(tipo.getTipo());
		archivo.close();
	}
	
	public void Modificar(TipoComputador tipo, int indice) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		int c = 0;
		
		archivo.seek(0);
		
		for(TipoComputador tipoAuxiliar : registros) {
			if(c == indice) {
				registros.add(indice, tipo);
				registros.remove(indice + 1);
				archivo.writeInt(tipo.getCodigo());
				archivo.writeUTF(tipo.getTipo());
			} else {
				archivo.writeInt(tipoAuxiliar.getCodigo());
				archivo.writeUTF(tipoAuxiliar.getTipo());
			}
			
			c++;
		}
		
		archivo.close();
	}
	
	public void Eliminar(TipoComputador tipo) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(0);
		registros.remove(tipo);
		
		for(TipoComputador tipoAuxiliar : registros) {
			archivo.writeInt(tipoAuxiliar.getCodigo());
			archivo.writeUTF(tipoAuxiliar.getTipo());
		}
		
		archivo.close();
	}
	
	public TipoComputador Buscar(int buscar) {
		for(TipoComputador tipo : registros) {
			if(tipo.getCodigo() == buscar)
				return tipo;
		}
		
		return null;
	}
	
	public void Listar() {
		for(TipoComputador tipo : registros)
			System.out.println(tipo);
	}
	
	public ArrayList<TipoComputador> archivoAarrayList() throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new TipoComputador(archivo.readInt(), archivo.readUTF()));
		
		archivo.close();
		
		return registros;
	}
	
	/*public void listar() {
		String wcadena = "";

		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/TipoComputador.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				wcadena = archivo.readInt() + " - ";
				wcadena += archivo.readUTF();
				
				System.out.println(wcadena);
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.println(e);
			System.out.println("Ocurrio un error");
		}
	}*/
	
	/*public int validarCodigonuevo(String t) {
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/TipoComputador.txt","r");
			
			do
			{
				System.out.println(t);
				codigo = datos.nextInt();
				datos.nextLine();
				
				archivo.seek(0);
				
				while(archivo.getFilePointer() < archivo.length())
				{
					int pos = archivo.readInt();
					
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
			RandomAccessFile archivo = new RandomAccessFile("./datos/TipoComputador.txt","r");
			
			do
			{
				System.out.println(t);
				codigo = datos.nextInt();
				datos.nextLine();
				
				archivo.seek(0);
				
				while(archivo.getFilePointer() < archivo.length())
				{
					int pos = archivo.readInt();

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
