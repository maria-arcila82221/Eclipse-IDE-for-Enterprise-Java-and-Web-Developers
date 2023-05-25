package vista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import bean.Chasis;
import logica.*;
import utilidad.*;

public class VistaChasis extends LChasis {
	
	private TratamientoArchivo t = new TratamientoArchivo();
	private String file = "./datos/Chasis.txt";
	private Scanner datos = new Scanner(System.in);
	
	public VistaChasis() throws IOException {}

	public void VistaInsertar() throws IOException {
		int codigo, ranuras;
		boolean adminCables;
		String modelo;
		
		if(t.Existe(file))
			codigo = t.validarCodigonuevo(registros, "Ingrese el codigo: ");
		else {
			System.out.println("Escriba el codigo: ");
			codigo = datos.nextInt();
			datos.nextLine();
		}

		System.out.println("Escriba la cantidad de ranuras: ");
		ranuras = datos.nextInt();
		datos.nextLine();
		System.out.println("¿Esta conectado? (true o false): ");
		adminCables = datos.nextBoolean();
		datos.nextLine();
		System.out.println("Escriba el modelo: ");
		modelo = datos.nextLine();
		
		Insertar(new Chasis(codigo, ranuras, adminCables, modelo));
	}

	public void VistaModificar() throws IOException {
		if (t.Existe(file)) {
			int codigo = t.validarCodigoviejo(registros, "Digite el codigo del chasis a modificar: ");
			Chasis chasis = Buscar(codigo);
			int indice = registros.indexOf(chasis);
			
			System.out.println("¿Desea modificar codigo? 1.Si 2.No: ");
			int r = datos.nextInt();
			datos.nextLine();
			if (r == 1)
				chasis.setCodigo(t.validarCodigonuevo(registros, "Ingrese nuevo codigo: "));
			
			System.out.println("¿Desea modificar la cantidad de ranuras? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nueva cantidad: ");
				chasis.setRanuras(datos.nextInt());
				datos.nextLine();
			}
			
			System.out.println("¿Desea modificar el administrador de cables (encendido o apagado)? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nuevo valor (true o false): ");
				chasis.setAdminCables(datos.nextBoolean());
				datos.nextLine();
			}
			
			System.out.println("¿Desea modificar el modelo? 1.Si 2.No: ");
			r = datos.nextInt();
			datos.nextLine();
			if (r == 1) {
				System.out.println("Ingrese nuevo modelo: ");
				chasis.setModelo(datos.nextLine());
			}
			
			t.eliminarArchivo(file);
			Modificar(chasis, indice);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaEliminar() throws IOException {
		if (t.Existe(file)) {
			Chasis chasis = Buscar(t.validarCodigoviejo(registros, "Digite el codigo del chasis a eliminar: "));
			
			t.eliminarArchivo(file);
			Eliminar(chasis);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaBuscar() {
		if (t.Existe(file)) {
			Chasis chasis = Buscar(t.validarCodigoviejo(registros, "Ingrese el codigo de chasis a buscar: "));
			
			System.out.println(chasis);
		} else
			System.out.println("No existe archivo o no esta lleno");
	}
	
	public void VistaListar() {
		if (t.Existe(file)) 
			Listar();
		else
			System.out.println("No existe archivo o no esta lleno");
	}
	
}

//si por lo menos uno de los metodos es abstracto, la clase tendra que ser abstracta
