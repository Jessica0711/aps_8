package br.com.aps.model;

import java.util.Arrays;

public class Cidades {

	private Cidade[] cidade;

	public Cidade[] getCidade() {
		return cidade;
	}

	public void setCidade(Cidade[] cidades) {
		this.cidade = cidades;
	}

	@Override
	public String toString() {
		return "Cidades [cidade=" + Arrays.toString(cidade) + "]";
	}

}
