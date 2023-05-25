package bean;

import java.io.Serializable;

import interfaces.Componentes;

public class ArmarComputador implements Componentes, Serializable, Comparable<ArmarComputador> {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private Chasis chasis;
	private DiscoDuro dd;
	private TipoComputador tipo;
	
	public ArmarComputador() {}
	
	public ArmarComputador(int codigo, Chasis chasis, DiscoDuro dd, TipoComputador tipo) {
		this.codigo = codigo;
		this.chasis = chasis;
		this.dd = dd;
		this.tipo = tipo;
	}
	
	public Chasis getChasis() {
		return chasis;
	}
	
	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}
	
	public DiscoDuro getDd() {
		return dd;
	}
	
	public void setDd(DiscoDuro dd) {
		this.dd = dd;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoComputador getTipo() {
		return tipo;
	}

	public void setTipo(TipoComputador tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + chasis.getCodigo() + " - " + dd.getCodigo() + " - " + tipo.getCodigo();
	}

	@Override
	public int compareTo(ArmarComputador pc) {
		return Integer.compare(this.codigo, pc.getCodigo());
	}
	
	
}

/*
Mostrar:
el pc con el chasis y las caracteristicas del chasis

Polimorfismo: lograr que un objeto se comporte a como se comportarian distintos objetos
*/
