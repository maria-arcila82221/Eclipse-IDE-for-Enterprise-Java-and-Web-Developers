package vista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import bean.*;
import logica.*;
import utilidad.*;

public class VistaArmarComputador extends LArmarComputador{

	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/ArmarComputador.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaArmarComputador() throws IOException {}
	
	public void VistaInsertar() throws IOException {
		int codigo;
		Chasis chasis;
		DiscoDuro dd;
		TipoComputador tipo;
		LChasis lchasis = new LChasis();
		LDiscoDuro ldd = new LDiscoDuro();
		LTipoComputador ltipo = new LTipoComputador();
		
		if(t.Existe(file))
			codigo = t.validarCodigonuevo(registros, "Ingrese el codigo: ");
		else {
			System.out.println("Ingrese el codigo: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}
		
		if(t.Existe("./datos/Chasis.txt"))
			chasis = lchasis.Buscar(t.validarCodigoviejo(lchasis.registros, "Ingrese codigo de chasis a asignar: "));
		else {
			System.out.println("No existen chasis, por favor vaya y agregue");
			
			return;
		}
		
		if(t.Existe("./datos/DiscoDuro.txt"))
			dd = ldd.Buscar(t.validarCodigoviejo(ldd.registros, "Ingrese codigo de disco duro a asignar: "));
		else {
			System.out.println("No existen discos duros, por favor vaya y agregue");
			
			return;
		}
		
		if(t.Existe("./datos/TipoComputador.txt"))
			tipo = ltipo.Buscar(t.validarCodigoviejo(ltipo.registros, "Ingrese codigo de tipo de computador a asignar: "));
		else {
			System.out.println("No existen tipos de computador, por favor vaya y agregue");
			
			return;
		}
		
		Insertar(new ArmarComputador(codigo, chasis, dd, tipo));
	}

	public void VistaModificar() throws IOException {
		Chasis chasis = new Chasis();
		DiscoDuro dd = new DiscoDuro();
		TipoComputador tipo = new TipoComputador();
		LChasis lchasis = new LChasis();
		LDiscoDuro ldd = new LDiscoDuro();
		LTipoComputador ltipo = new LTipoComputador();
		
		if (t.Existe(file)) {
			int codigo = t.validarCodigoviejo(registros, "Digite el codigo del computador a modificar: ");
			ArmarComputador pc = Buscar(codigo);
			int indice = registros.indexOf(pc);
			
			System.out.println("¿Desea modificar codigo? 1.Si 2.No: ");
			int r = datos.nextInt();
			datos.nextLine();
			if (r == 1)
				pc.setCodigo(t.validarCodigonuevo(registros, "Ingrese nuevo codigo: "));
			
			System.out.println("¿Desea modificar el chasis? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				if(t.Existe("./datos/Chasis.txt")) {
					int codigoC = t.validarCodigoviejo(lchasis.registros, "Digite el codigo del chasis a agregar: ");
					chasis = lchasis.Buscar(codigoC);
					pc.setChasis(chasis);
				} else
					System.out.println("No existen chasis");
			}
			
			System.out.println("¿Desea modificar el disco duro? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				if(t.Existe("./datos/DiscoDuro.txt")) {
					int codigoD = t.validarCodigoviejo(ldd.registros, "Digite el codigo del disco duro a agregar: ");
					dd = ldd.Buscar(codigoD);
					pc.setDd(dd);
				} else
					System.out.println("No existen discos duros");
			}
			
			System.out.println("¿Desea modificar el tipo de computador? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				if(t.Existe("./datos/TipoComputador.txt")) {
					int codigoT = t.validarCodigoviejo(ltipo.registros, "Digite el codigo del disco duro a agregar: ");
					tipo = ltipo.Buscar(codigoT);
					pc.setTipo(tipo);
				} else
					System.out.println("No existen tipos de computador");
			}
			
			t.eliminarArchivo(file);
			Modificar(pc, indice);
		} else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaEliminar() throws IOException {
		if (t.Existe(file)) {
			ArmarComputador pc = Buscar(t.validarCodigoviejo(registros, "Digite el codigo del computador a eliminar: "));
			
			t.eliminarArchivo(file);
			Eliminar(pc);
		} else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaBuscar() {
		if (t.Existe(file)) {
			ArmarComputador pc = Buscar(t.validarCodigoviejo(registros, "Ingrese el codigo de computador a buscar: "));
			
			System.out.println(pc);
		} else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaListar() {
		if (t.Existe(file)) 
			Listar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaSerializar() throws IOException {
		if (t.Existe(file))
			Serializar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
	public void VistaDeserializar() throws ClassNotFoundException, IOException {
		if (t.Existe("./datos/ArmarComputadorSerializado.txt"))
			Deserializar();
		else
			System.out.println("No existe archivo o esta vacio");
	}
	
}
