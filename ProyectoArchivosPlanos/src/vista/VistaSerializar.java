package vista;

import java.io.IOException;
import java.util.Scanner;

import logica.Serializar;
import utilidad.TratamientoArchivo;

public class VistaSerializar extends Serializar {

	private TratamientoArchivo t = new TratamientoArchivo();
	private Scanner datos = new Scanner(System.in);
	private String sfFile = "./datos/SecuencialF.txt";
	private String saFile = "./datos/SecuencialA.txt";
	private String afFile = "./datos/AleatorioF.txt";
	private String aaFile = "./datos/AleatorioA.txt";
	
	public void VistaserializarSecuencial() throws IOException {
		System.out.println("""
						Quieres convertir a:
						1. SecuencialF
						2. SecuencialA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(sfFile))
				serializarSecuencial(sfFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(saFile))
				serializarSecuencial(saFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
	public void VistaserializarAleatorio() throws IOException {
		System.out.println("""
						Quieres convertir a:
						1. AleatorioF
						2. AleatorioA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(afFile))
				serializarAleatorio(afFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(aaFile))
				serializarAleatorio(aaFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
	public void VistadeserializarSecuencial() throws IOException, ClassNotFoundException {
		System.out.println("""
						Quieres convertir a:
						1. SecuencialF
						2. SecuencialA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(sfFile))
				deserializarSecuencial(sfFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(saFile))
				deserializarSecuencial(saFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
	public void VistadeserializarAleatorio() throws IOException, ClassNotFoundException {
		System.out.println("""
						Quieres convertir a:
						1. AleatorioF
						2. AleatorioA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(afFile))
				deserializarAleatorio(afFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(aaFile))
				deserializarAleatorio(aaFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
}
