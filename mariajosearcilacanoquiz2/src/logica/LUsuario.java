package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import utilidades.*;
import vista.*;

public class LUsuario {

	public ArrayList<Usuario> registros = new ArrayList<>();
	private String file = "./datos/Usuarios.txt";
	
	public LUsuario() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(Usuario usuario) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(usuario.getCodigo());
		archivo.writeUTF(usuario.getNombre());
		archivo.close();
	}
	
	public int validarCodigonuevo(String t){ //no exista
		int cedula = 0;
		Scanner datos = new Scanner(System.in);
			
		do {
			Iterator<Usuario> apuntador = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntador.hasNext()) {
				Usuario usuario = apuntador.next();
				
				if(usuario.getCodigo()==cedula || cedula<=0) {
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
			Iterator<Usuario> apuntadorLista = registros.iterator();
			
			System.out.println(t);
			cedula = datos.nextInt();
			datos.nextLine();
			
			while(apuntadorLista.hasNext()) {
				Usuario usuario = apuntadorLista.next();
				
				if (usuario.getCodigo() == cedula) 
			        break;

			    if (!apuntadorLista.hasNext()) {
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
					
					archivo.readUTF();
					
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
	
	/*public Usuario Buscar(int buscar) {
		ArrayList<Usuario> registros = archivoAarrayList();
		Iterator<Usuario> apuntadorLista = registros.iterator();
		Usuario usuario = new Usuario();
		
		while(apuntadorLista.hasNext())
		{
			usuario = apuntadorLista.next();
			int codigo = usuario.getCodigo();
			
			if(codigo == buscar)
			{
				return usuario;
			}
		}
		
		return usuario;
	}*/
	public Usuario Buscar(int buscar) {
		for(Usuario usuario : registros) {
			if(usuario.getCodigo() == buscar)
				return usuario;
		}
		
		return null;
	}
	
	/*private ArrayList<Usuario> archivoAarrayList() {
		ArrayList<Usuario> registros = new ArrayList<Usuario>();
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/Usuario.txt","r");
			
			archivo.seek(0);
			
			while(archivo.getFilePointer() < archivo.length())
			{
				registros.add(new Usuario(archivo.readInt(), archivo.readUTF()));
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
	public ArrayList<Usuario> archivoAarrayList() throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new Usuario(archivo.readInt(), archivo.readUTF()));
		
		archivo.close();
		
		return registros;
	}
	
	//si lo quiero leer de algo ya escrito por mi externamente tiene que ser secuencial
	
}
