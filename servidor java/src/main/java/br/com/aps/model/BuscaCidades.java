package br.com.aps.model;

public class BuscaCidades {

	private Cidades cidades;

	public BuscaCidades(Cidades cidades) {
		super();
		this.cidades = cidades;
	}

	public Cidades getCidades() {
		return cidades;
	}

	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}

	@Override
	public String toString() {
		return "BuscaCidades [cidades=" + cidades + "]";
	}

}
