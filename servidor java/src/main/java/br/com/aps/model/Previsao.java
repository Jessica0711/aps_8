package br.com.aps.model;

import java.util.List;

public class Previsao {

	private String minima;

	private String maxima;

	private String tempo;

	private String iuv;

	private String dia;

	private List<Aviso> avisos;

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}

	public String getMinima() {
		return minima;
	}

	public void setMinima(String minima) {
		this.minima = minima;
	}

	public String getMaxima() {
		return maxima;
	}

	public void setMaxima(String maxima) {
		this.maxima = maxima;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getIuv() {
		return iuv;
	}

	public void setIuv(String iuv) {
		this.iuv = iuv;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Previsao [minima = " + minima + ", maxima = " + maxima + ", tempo = " + tempo + ", iuv = " + iuv
				+ ", dia = " + dia + "]";
	}

}
