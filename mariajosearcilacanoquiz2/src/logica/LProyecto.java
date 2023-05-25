package logica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import vista.*;

public class LProyecto {

	public void Insertar(int codigo, Tarea tarea) {
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","rw");
			
			archivo.seek(archivo.length());
			archivo.writeInt(codigo);
			archivo.writeInt(tarea.getCodigo());
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.println(e);
			System.out.println("Ocurrio un error");
		}
	}
	
	public void Modificar(int modificar) {
		Scanner datos = new Scanner(System.in);
		ArrayList<Proyecto> registros = archivoAarrayList();
		Iterator<Proyecto> apuntadorLista = registros.iterator();
		LTarea ltarea = new LTarea();
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","rw");
			
			archivo.seek(0);
			
			while(apuntadorLista.hasNext())
			{
				Proyecto proyecto = apuntadorLista.next();
				int codigo = proyecto.getCodigo();
				
				if(codigo == modificar)
				{
					System.out.println("¿Desea modificar codigo? 1.Si 2.No: ");
					int r = datos.nextInt();
					datos.nextLine();
					if (r == 1)
					{
						proyecto.setCodigo(validarCodigonuevo("Ingrese nuevo codigo: "));
					}
					
					System.out.println("¿Desea modificar la tarea? 1.Si 2.No: ");
					r = datos.nextInt();
					datos.nextLine();
					if (r == 1)
					{
						int codigoTarea = ltarea.validarCodigoviejo("Ingrese nueva tarea: ");
						Tarea tarea = ltarea.Buscar(codigoTarea);
						proyecto.setTarea(tarea);
					}
				}
				
				archivo.writeInt(proyecto.getCodigo());
				archivo.writeInt(proyecto.getTarea().getCodigo());
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			System.out.println("Ocurrio un error");
		}
	}
	
	public void Eliminar(int eliminar) {
		Scanner datos = new Scanner(System.in);
		ArrayList<Proyecto> registros = archivoAarrayList();
		Iterator<Proyecto> apuntadorLista = registros.iterator();
		
		try
		{
			eliminarArchivo();
			
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","rw");
			
			archivo.seek(0);
			
			while(apuntadorLista.hasNext())
			{
				Proyecto proyecto = apuntadorLista.next();
				int codigo = proyecto.getCodigo();
				
				if(codigo != eliminar)
				{
					archivo.writeInt(proyecto.getCodigo());
					archivo.writeInt(proyecto.getTarea().getCodigo());
				}
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			System.out.println("Ocurrio un error");
		}
	}
	
	public void Consultar(int buscar) {
		ArrayList<Proyecto> registros = archivoAarrayList();
		Iterator<Proyecto> apuntadorLista = registros.iterator();
		
		while(apuntadorLista.hasNext())
		{
			Proyecto proyecto = apuntadorLista.next();
			int codigo = proyecto.getCodigo();
			
			if(codigo == buscar)
			{
				System.out.println(proyecto.getCodigo() + " - " + proyecto.getTarea().getCodigo());
			}
		}
	}
	
	public void Listar() {
		String wcadena = "";

		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				wcadena = archivo.readInt() + " - ";
				wcadena += archivo.readInt();
				
				System.out.println(wcadena);
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.print(e);
			System.out.println("Ocurrio un error");
		}
	}
	
	private ArrayList<Proyecto> archivoAarrayList() {
		ArrayList<Proyecto> registros = new ArrayList<Proyecto>();
		Tarea tarea = new Tarea();
		LTarea ltarea = new LTarea();
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				int codigo = archivo.readInt();
				int starea = archivo.readInt();
				tarea = ltarea.Buscar(codigo);;
				
				registros.add(new Proyecto(codigo, tarea));
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			System.out.println("Ocurrio un error");
		}
		
		return registros;
	}
	
	private void eliminarArchivo() {
		File f = new File("./datos/Proyecto.txt");
		
		if (!f.delete())
		{
			System.out.println("El fichero no se pudo borrar");
		}
	}
	
	public int validarCodigonuevo(String t){
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","rw");
			
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
    }
	
	public int validarCodigoviejo(String t){ //exista
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		boolean b = false;;
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyecto.txt","r");
			
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
					
					if(pos == codigo)
					{
						b = true;
						
						archivo.seek(archivo.length());
					}
				}
				
				if(!b)
				{
					System.out.println("Ingrese un codigo valido");
					
					codigo = -1;
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
    }
	
}
