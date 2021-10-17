package br.unicesumar.adsis4s2021.DioneADS2021.MeuPessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseEntity;

@Entity
public class MeuPessoa extends MinhaBaseEntity{

		private String nome;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="morador_id")
		private List<MeuEndereco> MeusEnderecos = new ArrayList<>();
		
		public MeuPessoa() {
			
		}
		
		public MeuPessoa(String id, String nome)  {
			super(id);
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public List<MeuEndereco> getMeuEnderecos() {
			return MeusEnderecos;
		}
}

