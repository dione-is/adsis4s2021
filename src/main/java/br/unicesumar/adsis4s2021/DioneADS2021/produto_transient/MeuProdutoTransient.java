package br.unicesumar.adsis4s2021.DioneADS2021.produto_transient;

public class MeuProdutoTransient {

	private String nome;
	private String id;
	private double preco;
	
	public MeuProdutoTransient(String id, String nome, double preco) {
		this.nome = nome;
		this.id = id;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}
	
	
}
