package bean;

import java.io.Serializable;

import interfaces.Componentes;
import logica.*;

public class Chasis implements Componentes, Serializable, Comparable<Chasis> {

	private static final long serialVersionUID = 1L;
	private int codigo, ranuras;
	private boolean adminCables;
	private String modelo; //ATX, ATM, ITX
	//public int largoPlaca: Ya de por si deberia ser publico
	
	public Chasis() {}
	
	public Chasis(int codigo, int ranuras, boolean adminCables, String modelo) {
		this.codigo = codigo;
		this.ranuras = ranuras;
		this.adminCables = adminCables;
		this.modelo = modelo;
	}
	
	public int getRanuras() {
		return ranuras;
	}
	
	public void setRanuras(int ranuras) {
		this.ranuras = ranuras;
	}
	
	public boolean getAdminCables() {
		return adminCables;
	}
	
	public void setAdminCables(boolean adminCables) {
		this.adminCables = adminCables;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + ranuras + " - " + adminCables + " - " + modelo;
	}

	@Override
	public int compareTo(Chasis chasis) {
		return Integer.compare(this.codigo, chasis.getCodigo());
	}
	
}
