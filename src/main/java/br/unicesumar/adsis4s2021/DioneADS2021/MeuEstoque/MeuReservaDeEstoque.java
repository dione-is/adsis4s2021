package br.unicesumar.adsis4s2021.DioneADS2021.MeuEstoque;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuPessoa.MeuPessoa;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuProduto.MeuProduto;
import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseEntity;

@Entity
public class MeuReservaDeEstoque extends MinhaBaseEntity {
		
		@ManyToOne
		@JoinColumn( name = "cliente_id")
		private MeuPessoa cliente;
		private Date efetuadaEm;
		
		@ManyToOne
		private MeuProduto produto;
		private BigDecimal quantidade;
		
		public MeuReservaDeEstoque(MeuPessoa cliente, Date efetuadaEm, MeuProduto produto, BigDecimal quanditade) {
			super();
			this.cliente = cliente;
			this.efetuadaEm =  efetuadaEm;
			this.produto = produto;
			this.quantidade = quantidade;
		}
		
		public MeuReservaDeEstoque() {
			super();
		}

		public MeuPessoa getCliente() {
			return cliente;
		}

		public void setCliente(MeuPessoa cliente) {
			this.cliente = cliente;
		}

		public Date getEfetuadaEm() {
			return efetuadaEm;
		}

		public void setEfetuadaEm(Date efetuadaEm) {
			this.efetuadaEm = efetuadaEm;
		}

		public MeuProduto getProduto() {
			return produto;
		}

		public void setProduto(MeuProduto produto) {
			this.produto = produto;
		}

		
		
}
