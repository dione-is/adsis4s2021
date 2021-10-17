package br.unicesumar.adsis4s2021.DioneADS2021.cor;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Cor {
	private String nome;
	private String sigla;
	
	@JsonCreator
	public Cor (String cor, String sigla) {
		this.nome = nome;
		this.sigla= sigla;
	}
	
	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
	
}
