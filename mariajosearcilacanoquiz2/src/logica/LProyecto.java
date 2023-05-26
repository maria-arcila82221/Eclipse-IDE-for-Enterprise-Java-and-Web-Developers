package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import utilidades.TratamientoArchivo;
import vista.*;

public class LProyecto {

	public ArrayList<Proyecto> registros = new ArrayList<>();
	private String file = "./datos/Proyectos.txt";
	
	public LProyecto() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public int validarCodigonuevo(String t){ //no exista
		int cedula = 0;
		Scanner datos = new Scanner(System.in);
			
		do {
			Iterator<Proyecto> apuntador = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntador.hasNext()) {
				Proyecto proyecto = apuntador.next();
				
				if(proyecto.getCodigo()==cedula || cedula<=0) {
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
			Iterator<Proyecto> apuntador = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntador.hasNext()) {
				Proyecto proyecto = apuntador.next();
				
				if (proyecto.getCodigo() == cedula) 
			        break;

			    if (!apuntador.hasNext()) {
			        System.out.println("El codigo no existe, inserte otra");
			        
			        cedula = -1;
			    }
			}
		} while(cedula == -1);
		
		return cedula;
    }
	
	/*public void Insertar(int codigo, String nombre, Tarea tarea) {
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Proyectos.txt","rw");
			
			archivo.seek(archivo.length());
			archivo.writeInt(codigo);
			archivo.writeUTF(nombre);
			archivo.writeInt(tarea.getCodigo());
			archivo.close();
		}
		catch(IOException e) 
		{
			System.out.println(e);
			System.out.println("Ocurrio un error");
		}
	}*/
	public void Insertar(Proyecto proyecto) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(proyecto.getCodigo());
		archivo.writeUTF(proyecto.getNombre());
		archivo.writeInt(proyecto.getTarea().getCodigo());
		archivo.close();
	}
	
	public Proyecto Buscar(int buscar) {
		for(Proyecto proyecto : registros) {
			if(proyecto.getCodigo() == buscar)
				return proyecto;
		}
		
		return null;
	}
	
	public void Listar() {
		for(Proyecto proyecto : registros)
			System.out.println(proyecto);
	}
	
	public void Listar(String d) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(d,"r");
		LTarea ltarea = new LTarea();
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length()) {
			Proyecto proyecto = new Proyecto();
			proyecto.setCodigo(archivo.readInt());
			proyecto.setNombre(archivo.readUTF());
			proyecto.setTarea(ltarea.Buscar(archivo.readInt()));
			
			System.out.println(proyecto);
		}
		
		archivo.close();
	}
	
	public void Serializar() throws IOException {
		Proyecto[] sregistros = new Proyecto[registros.size()];
		
		for(int i=0; i<registros.size(); i++) {
			sregistros[i] = new Proyecto();
			sregistros[i].setCodigo(registros.get(i).getCodigo());
			sregistros[i].setNombre(registros.get(i).getNombre());
			sregistros[i].setTarea(registros.get(i).getTarea());
		}

		ObjectOutputStream archivo_salida = new ObjectOutputStream(new FileOutputStream("./datos/ProyectosSerializado.txt"));
		//se puede usar .dat?
		archivo_salida.writeObject(sregistros);
		archivo_salida.close();
	}
	
	public void Deserializar() throws IOException, ClassNotFoundException {
		ObjectInputStream leer_datos = new ObjectInputStream(new FileInputStream("./datos/ProyectosSerializado.txt"));
		Proyecto[] datos_leidos = (Proyecto[]) leer_datos.readObject();
		
		leer_datos.close();
		
		for(Proyecto proyecto : datos_leidos)
			System.out.println(proyecto);
	}
	
	public ArrayList<Proyecto> archivoAarrayList() throws IOException {
		LTarea ltarea = new LTarea();
		TratamientoArchivo t = new TratamientoArchivo(); 

		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new Proyecto(archivo.readInt(), archivo.readUTF(), ltarea.Buscar(archivo.readInt())));
		
		archivo.close();
		
		return registros;
	}
	
	/*public void Modificar(int modificar) {
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
    }*/
	
}
