package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import utilidades.TratamientoArchivo;
import vista.*;

public class LTarea {

	public ArrayList<Tarea> registros = new ArrayList<>();
	private String file = "./datos/Tareas.txt";
	
	public LTarea() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(Tarea tarea) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(tarea.getCodigo());
		archivo.writeUTF(tarea.getTarea());
		archivo.writeInt(tarea.getUsuario().getCodigo());
		archivo.close();
	}
	
	public int validarCodigonuevo(String t){ //no exista
		int cedula = 0;
		Scanner datos = new Scanner(System.in);
			
		do {
			Iterator<Tarea> apuntador = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntador.hasNext()) {
				Tarea tarea = apuntador.next();
				
				if(tarea.getCodigo()==cedula || cedula<=0) {
					System.out.println("Ingrese un codigo no existente o diferente de cero o no negativa");
					
					cedula = -1;
					
					break;
				}
			}
		} while(cedula == -1);
		
		return cedula;
    }
	
	public int validarCodigoviejo(String t){ //exista
		int cedula = 0;
		Scanner datos = new Scanner(System.in);

		do {
			Iterator<Tarea> apuntador = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntador.hasNext()) {
				Tarea tarea = apuntador.next();
				
				if (tarea.getCodigo() == cedula) 
			        break;

			    if (!apuntador.hasNext()) {
			        System.out.println("El codigo no existe, inserte otra");
			        
			        cedula = -1;
			    }
			}
		} while(cedula == -1);
		
		return cedula;
    }
	
	/*public int validarCodigonuevo(String t){
		int codigo = 0;
		Scanner datos = new Scanner(System.in);
		
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
    }*/
	
	/*public Tarea Buscar(int buscar) {
		ArrayList<Tarea> registros = archivoAarrayList();
		Iterator<Tarea> apuntadorLista = registros.iterator();
		Tarea tarea = new Tarea();
		
		while(apuntadorLista.hasNext())
		{
			tarea = apuntadorLista.next();
			int codigo = tarea.getCodigo();
			
			if(codigo == buscar)
			{
				return tarea;
			}
		}
		
		return tarea;
	}
	
	private ArrayList<Tarea> archivoAarrayList() {
		ArrayList<Tarea> registros = new ArrayList<Tarea>();
		LTarea ltarea = new LTarea();
		LUsuario lusuario = new LUsuario();
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Tarea.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				int codigo = archivo.readInt();
				String tarea = archivo.readUTF();
				int usuario = archivo.readInt();
				Tarea tarea1 = ltarea.Buscar(codigo);
				Usuario usuario1 = lusuario.Buscar(usuario);
				
				registros.add(new Tarea(codigo, tarea, usuario1));
			}
			
			archivo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			System.out.println("Ocurrio un error");
		}
		
		return registros;
	}*/
	
	public Tarea Buscar(int buscar) {
		for(Tarea tarea : registros) {
			if(tarea.getCodigo() == buscar)
				return tarea;
		}
		
		return null;
	}
	
	public ArrayList<Tarea> archivoAarrayList() throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		LUsuario lusuario = new LUsuario();
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new Tarea(archivo.readInt(), archivo.readUTF(), lusuario.Buscar(archivo.readInt())));
		
		archivo.close();
		
		return registros;
	}
	
}
