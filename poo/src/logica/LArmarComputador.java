package logica;
//fdicks, como hacer una particion en windows y linux
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.*;
import interfaces.ICrud;
import utilidad.TratamientoArchivo;

public class LArmarComputador implements ICrud<ArmarComputador> {
	
	public ArrayList<ArmarComputador> registros = new ArrayList<>();
	private String file = "./datos/ArmarComputador.txt";
	
	public LArmarComputador() throws IOException {
		TratamientoArchivo t = new TratamientoArchivo();
		
		if(t.Existe(file))
			registros = t.ordenarCodigos(archivoAarrayList());
	}
	
	public void Insertar(ArmarComputador pc) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(archivo.length());
		archivo.writeInt(pc.getCodigo());
		archivo.writeInt(pc.getChasis().getCodigo());
		archivo.writeInt(pc.getDd().getCodigo());
		archivo.writeInt(pc.getTipo().getCodigo());
		archivo.close();
	}
	
	public void Modificar(ArmarComputador pc, int indice) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		int c = 0;
		
		archivo.seek(0);
		
		for(ArmarComputador pcAuxiliar : registros) {
			if(c == indice) {
				archivo.writeInt(pc.getCodigo());
				archivo.writeInt(pc.getChasis().getCodigo());
				archivo.writeInt(pc.getDd().getCodigo());
				archivo.writeInt(pc.getTipo().getCodigo());
			} else {
				archivo.writeInt(pcAuxiliar.getCodigo());
				archivo.writeInt(pcAuxiliar.getChasis().getCodigo());
				archivo.writeInt(pcAuxiliar.getDd().getCodigo());
				archivo.writeInt(pcAuxiliar.getTipo().getCodigo());
			}
			
			c++;
		}
		
		archivo.close();	
	}
	
	public void Eliminar(ArmarComputador pc) throws IOException {
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");
		
		archivo.seek(0);
		registros.remove(pc);
		
		for(ArmarComputador pcAuxiliar : registros) {
			archivo.writeInt(pcAuxiliar.getCodigo());
			archivo.writeInt(pcAuxiliar.getChasis().getCodigo());
			archivo.writeInt(pcAuxiliar.getDd().getCodigo());
			archivo.writeInt(pcAuxiliar.getTipo().getCodigo());
		}
		
		archivo.close();
	}
	
	public ArmarComputador Buscar(int buscar) {
		for(ArmarComputador pc : registros) {
			if(pc.getCodigo() == buscar)
				return pc;
		}
		
		return null;
	}
	
	public void Listar() {
		for(ArmarComputador pc : registros)
			System.out.println(pc);
	}
	
	public void Serializar() throws IOException {
		ArmarComputador[] sregistros = new ArmarComputador[registros.size()];
		
		for(int i=0; i<registros.size(); i++) {
			sregistros[i] = new ArmarComputador();
			sregistros[i].setCodigo(registros.get(i).getCodigo());
			sregistros[i].setChasis(registros.get(i).getChasis());
			sregistros[i].setDd(registros.get(i).getDd());
			sregistros[i].setTipo(registros.get(i).getTipo());
		}

		ObjectOutputStream archivo_salida = new ObjectOutputStream(new FileOutputStream("./datos/ArmarComputadorSerializado.txt"));
		//se puede usar .dat?
		archivo_salida.writeObject(sregistros);
		archivo_salida.close();
	}
	
	public void Deserializar() throws IOException, ClassNotFoundException {
		ObjectInputStream leer_datos = new ObjectInputStream(new FileInputStream("./datos/ArmarComputadorSerializado.txt"));
		ArmarComputador[] datos_leidos = (ArmarComputador[]) leer_datos.readObject();
		
		leer_datos.close();
		
		for(ArmarComputador pc : datos_leidos)
			System.out.println(pc);
	}
	
	public ArrayList<ArmarComputador> archivoAarrayList() throws IOException {
		LChasis lchasis = new LChasis();
		LDiscoDuro ldd = new LDiscoDuro();
		LTipoComputador ltipo = new LTipoComputador();
		TratamientoArchivo t = new TratamientoArchivo(); 

		RandomAccessFile archivo = new RandomAccessFile(file,"r");
		
		archivo.seek(0);
		
		while(archivo.getFilePointer() < archivo.length())
			registros.add(new ArmarComputador(archivo.readInt(), lchasis.Buscar(archivo.readInt()), ldd.Buscar(archivo.readInt()), ltipo.Buscar(archivo.readInt())));
		
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
	
	/*public void InsertarSerializado()
	{
		ArrayList<BEmpleado> listaEmpleados = recuparDatosEmpleados();
		BEmpleado[] lempleado = new BEmpleado[listaEmpleados.size()];
		for(int i=0; i < listaEmpleados.size(); i++)
		{
	
		lempleado[i] = new BEmpleado();
		lempleado[i].setIdEmp(listaEmpleados.get(i).getIdEmp());
		lempleado[i].setNombreEmp(listaEmpleados.get(i).getNombreEmp());
		lempleado[i].setSueldoEmp(listaEmpleados.get(i).getSueldoEmp());
		lempleado[i].setFechaNacEmp(listaEmpleados.get(i).getFechaNacEmp());
	
		}
		try
		{
		FileOutputStream ruta_salida = new FileOutputStream("./empleadosSerializados.txt");
		ObjectOutputStream archivo_salida = new ObjectOutputStream(ruta_salida);
		archivo_salida.writeObject(lempleado);
		archivo_salida.close();
		}catch(Exception e)
		{
	
		System.out.println("Problemas con el acceso al archivo de datos - " + e);
	
		}
	}
	
	public void ListarSerializado() {
		
	}*/
	
}
	

