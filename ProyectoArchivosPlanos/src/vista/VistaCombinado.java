package vista;

import java.io.IOException;
import java.util.Scanner;

import logica.Combinado;
import utilidad.TratamientoArchivo;

public class VistaCombinado extends Combinado {

	private TratamientoArchivo t = new TratamientoArchivo();
	private Scanner datos = new Scanner(System.in);
	private String sfFile = "./datos/SecuencialF.txt";
	private String saFile = "./datos/SecuencialA.txt";
	private String afFile = "./datos/AleatorioF.txt";
	private String aaFile = "./datos/AleatorioA.txt";
	
	public void VistasecuencialAaleatorio() throws IOException {
		System.out.println("""
						Quieres convertir a:
						1. SecuencialF
						2. SecuencialA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(sfFile))
				secuencialAaleatorio(sfFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(saFile))
				secuencialAaleatorio(saFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
	public void VistaaleatorioAsecuencial() throws IOException {
		System.out.println("""
						Quieres convertir a:
						1. AleatorioF
						2. AleatorioA
							""");
		int r = datos.nextInt();
		if(r == 1) {
			if(t.Existe(afFile))
				aleatorioAsecuencial(afFile);
			else
				System.out.println("No existe archivo o esta vacio");
		} else {
			if(t.Existe(aaFile))
				aleatorioAsecuencial(aaFile);
			else
				System.out.println("No existe archivo o esta vacio");
		}
	}
	
}
