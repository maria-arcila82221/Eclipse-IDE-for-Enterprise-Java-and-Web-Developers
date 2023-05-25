package vista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import bean.Chasis;
import bean.TipoComputador;
import logica.LTipoComputador;
import utilidad.TratamientoArchivo;

public class VistaTipoComputador extends LTipoComputador{

	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/TipoComputador.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaTipoComputador() throws IOException {}
	
	public void VistaInsertar() throws IOException {
		int codigo;
		String tipo;
		
		if(t.Existe(file))
			codigo = t.validarCodigonuevo(registros, "Ingrese el codigo: ");
		else
		{
			System.out.println("Ingrese el codigo: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}
		
		System.out.println("Escriba el tipo de computador: ");
		tipo = datos.nextLine();
		
		Insertar(new TipoComputador(codigo, tipo));
	}

	public void VistaModificar() throws IOException {
		if(t.Existe(file)) {
			int codigo = t.validarCodigoviejo(registros, "Ingrese el codigo de tipo de computador a modificar: ");
			TipoComputador tipo = Buscar(codigo);
			int indice = registros.indexOf(tipo);
			
			System.out.println("¿Desea modificar codigo? 1.Si 2.No: ");
			int r = datos.nextInt();
			datos.nextLine();
			if (r == 1)
				tipo.setCodigo(t.validarCodigonuevo(registros, "Ingrese nuevo codigo: "));
			
			System.out.println("¿Desea modificar el tipo de computador? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1)
				System.out.println("Ingrese nuevo tipo: ");
				tipo.setTipo(datos.nextLine());
			
			t.eliminarArchivo(file);
			Modificar(tipo, indice);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaEliminar() throws IOException {
		if(t.Existe(file)) {
			TipoComputador tipo = Buscar(t.validarCodigoviejo(registros, "Digite el codigo del tipo de computador a eliminar: "));
			
			t.eliminarArchivo(file);
			Eliminar(tipo);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaBuscar() {
		if(t.Existe(file)) {
			TipoComputador tipo = Buscar(t.validarCodigoviejo(registros, "Ingrese el codigo del tipo de computador a buscar: "));

			System.out.println(tipo);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaListar() {
		if(t.Existe(file))
			Listar();
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
}
