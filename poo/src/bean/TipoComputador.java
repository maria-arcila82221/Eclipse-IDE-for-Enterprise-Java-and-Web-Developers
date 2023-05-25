package bean;

import java.io.Serializable;

import interfaces.Componentes;
import logica.*;

public class TipoComputador implements Componentes, Serializable, Comparable<TipoComputador> {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String tipo;

	public TipoComputador(){}
	
	public TipoComputador(int codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + tipo;
	}

	@Override
	public int compareTo(TipoComputador tipo) {
		return Integer.compare(this.codigo, tipo.getCodigo());
	}
	
}
