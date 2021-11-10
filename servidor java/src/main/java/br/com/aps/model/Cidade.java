package br.com.aps.model;

import java.util.Arrays;

public class Cidade {

	private String id;
	private String uf;
	private String atualizacao;
	private Previsao[] previsao;
	private String nome;

	public Cidade() {
	}

	public Cidade(String id, String uf, String atualizacao, Previsao[] previsao, String nome) {
		super();
		this.id = id;
		this.uf = uf;
		this.atualizacao = atualizacao;
		this.previsao = previsao;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(String atualizacao) {
		this.atualizacao = atualizacao;
	}

	public Previsao[] getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Previsao[] previsao) {
		this.previsao = previsao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [uf=" + uf + ", atualizacao=" + atualizacao + ", previsao=" + Arrays.toString(previsao)
				+ ", nome=" + nome + "]";
	}

}
