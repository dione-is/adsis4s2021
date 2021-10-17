package br.unicesumar.adsis4s2021.DioneADS2021.MeuPet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MeuPet {
	
	@Id
	private String id;
	private String nome;
	
	public MeuPet() {
	}
	
	public MeuPet(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

}
