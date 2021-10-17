package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuPessoa.MeuPessoa;


@Entity
public class MeuPedido {
	@Id
	private String id;
	private Long numero;
	private Date emitidoEm;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="meupedido_id")
	private List<MeuItemPedido> itens;
	
	//Pessoa    1 [-cliente] ------------------------------> 0..n [-pedidos]  Pedido
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private MeuPessoa cliente;
	
	public MeuPedido() {
		
	}

	public String getId() {
		return id;
	}

	public Long getNumero() {
		return numero;
	}

	
	public List<MeuItemPedido> getItens(){
		return itens;
	}

	public Date getEmitidoEm() {
		return emitidoEm;
	}

	public MeuPessoa getCliente() {
		return cliente;
	}
	
	
	
}
