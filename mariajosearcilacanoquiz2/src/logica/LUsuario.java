package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.Tarea;
import bean.*;
import vista.*;

public class LUsuario {

	public int validarCodigonuevo(String t){
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
    }
	
	public Usuario Buscar(int buscar) {
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
	}
	
	private ArrayList<Usuario> archivoAarrayList() {
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
	}
	
}
