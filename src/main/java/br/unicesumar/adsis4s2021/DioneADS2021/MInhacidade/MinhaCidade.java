package br.unicesumar.adsis4s2021.DioneADS2021.MInhacidade;

import javax.persistence.Entity;

import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseEntity;

@Entity
public class MinhaCidade extends MinhaBaseEntity{
	
	private String nome;
	
	public MinhaCidade() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
