package br.unicesumar.adsis4s2021.DioneADS2021.MeuProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.DioneADS2021.produto_transient.MeuProdutoTransient;
import br.unicesumar.adsis4s2021.produto.Produto;



@RestController
@RequestMapping("/meusprodutos")
public class MeuProdutoController {
		
		@Autowired
		private MeuProdutoRepository repo;
		
		@GetMapping("/precomaior")
		public List<MeuProduto> getPrecoMaior(@RequestParam double preco) {
			return repo.recuperarPrecoMaior(preco);
		}

		@DeleteMapping("/{id}")
		public void deletePeloId(@PathVariable("id") String id) {
			repo.deleteById(id);
		}
		
		@GetMapping("/{id}")
		public MeuProduto getPeloId(@PathVariable("id") String id) {
			return repo.findById(id).get();
		}

	
		@GetMapping
		public List<MeuProduto> getMeuProduto(){
			return repo.findAll();
		}
		
		@PostMapping
		public String post(@RequestBody MeuProduto novo) {
			if(repo.findById(novo.getId()).isPresent()) {
				throw new RuntimeException("Seu produto ja existe, caso queira atualizar faça um put !");
			}
			novo = repo.save(novo);
			return novo.getId();
		}
		
		@PutMapping("/{id}")
		public String put(@RequestBody MeuProduto modificado, @PathVariable("id") String id) {
			if(!modificado.getId().equals(id)) {
				throw new RuntimeException("Para atualizar um produto, os ids devems ser igauis");
			}
			if(!repo.findById(id).isPresent()) {
				throw new RuntimeException("Seu produto nao existe, faça um post ao inves de put !");
			}
			modificado = repo.save(modificado);
			return modificado.getId();
		}
		
		
		
}
