package br.unicesumar.adsis4s2021.DioneADS2021.DDIGgroup;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plantio {
	@Id
	private String nome;
	private Date dataPlantio;
	private int prazoColheita;
	private int terreno;
	
	public Plantio() {
		
	}
	
	public Plantio(String nome, Date dataPlantio, int prazoColheita, int terreno) {
		this.nome = nome;
		this.dataPlantio = dataPlantio;
		this.prazoColheita = prazoColheita;
		this.terreno = terreno;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataPlantio() {
		return dataPlantio;
	}

	public int getPrazoColheita() {
		return prazoColheita;
	}

	public int getTerreno() {
		return terreno;
	}
	
	
	

}
