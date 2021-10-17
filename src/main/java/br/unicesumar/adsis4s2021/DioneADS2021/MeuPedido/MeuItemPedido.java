package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuProduto.MeuProduto;

@Entity
public class MeuItemPedido {

	@Id
	private String id;
	private BigDecimal precoUnitario;
	private BigDecimal porcentualDesconto;
	private BigDecimal quantidade;
	
	@ManyToOne
	private MeuProduto produto;
	
	public MeuItemPedido() {
		
	}

	public String getId() {
		return id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public BigDecimal getPorcentualDesconto() {
		return porcentualDesconto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public MeuProduto getProduto() {
		return produto;
	}
	
	
}
