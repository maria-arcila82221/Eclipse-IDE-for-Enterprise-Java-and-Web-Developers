package bean;

import java.io.Serializable;

import interfaces.Componentes;
import logica.*;

public class DiscoDuro implements Componentes, Serializable, Comparable<DiscoDuro> {

	private static final long serialVersionUID = 1L;
	private int codigo, capacidad; //Capacidad de almacenamiento en GigaByte
	private String tipoDisco; //Define si es magnetico o SSD
	private String interfaz; //IDE, SATA, SCSI, SAS, SATA Express
	
	public DiscoDuro(){}
	
	public DiscoDuro(int codigo, int capacidad, String tipoDisco, String interfaz) {
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.tipoDisco = tipoDisco;
		this.interfaz = interfaz;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getInterfaz() {
		return interfaz;
	}
	
	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}

	public String getTipoDisco() {
		return tipoDisco;
	}

	public void setTipoDisco(String tipoDisco) {
		this.tipoDisco = tipoDisco;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + capacidad + " - " + tipoDisco + " - " + interfaz;
	}

	@Override
	public int compareTo(DiscoDuro dd) {
		return Integer.compare(this.codigo, dd.getCodigo());
	}

	
}
