package br.unicesumar.adsis4s2021.DioneADS2021.produto_transient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtosTransient")
public class MeuProdutoTransientController {

	private List<MeuProdutoTransient> produtos = new ArrayList<>();
	
	public MeuProdutoTransientController() {
		produtos.add(new MeuProdutoTransient("1", "GPU ", 2599.99));
		produtos.add(new MeuProdutoTransient("2", "CPU ", 1669.99));
		produtos.add(new MeuProdutoTransient("3", "SSD ", 599.99));
	}
	
	@PostMapping
	public void postProduto(@RequestBody MeuProdutoTransient novoProduto) {
		produtos.add(novoProduto);
	}
	
	@GetMapping
	public List<MeuProdutoTransient>getProdutos(){
		return this.produtos;
	}
	
	@GetMapping("/{id}")
	public MeuProdutoTransient getProdutoPeloId(@PathVariable("id") String id) {
		for (MeuProdutoTransient p: produtos) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProdutoPeloId(@PathVariable("id") String id) {
		MeuProdutoTransient paraRemover = null;
		for(MeuProdutoTransient p: produtos) {
			if (p.getId().equals(id)) {
				paraRemover = p;
			}
		}
		if(paraRemover != null) {
			produtos.remove(paraRemover);
		}
	}
}
