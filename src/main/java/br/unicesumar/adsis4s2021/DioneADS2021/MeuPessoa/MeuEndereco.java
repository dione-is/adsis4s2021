package br.unicesumar.adsis4s2021.DioneADS2021.MeuPessoa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import br.unicesumar.adsis4s2021.DioneADS2021.MInhacidade.MinhaCidade;
import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseEntity;



@Entity
public class MeuEndereco extends MinhaBaseEntity{

	private String logradouro;
	private String numero;
	private String bairro;
	
	@ManyToOne
	private MinhaCidade cidade;
	
	public MeuEndereco() {
		super();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public MinhaCidade getCidade() {
		return cidade;
	}

	public void setMinhaCidade(MinhaCidade cidade) {
		this.cidade = cidade;
	}
		
	
}
