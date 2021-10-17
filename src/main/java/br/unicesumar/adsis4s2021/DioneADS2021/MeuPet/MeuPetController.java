package br.unicesumar.adsis4s2021.DioneADS2021.MeuPet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.produto.Produto;



@RestController
@RequestMapping("/meuspets")
public class MeuPetController {
		
		@Autowired
		private MeuPetRepository repo;
		

		@DeleteMapping("/{id}")
		public void deletePeloId(@PathVariable("id") String id) {
			repo.deleteById(id);
		}
		
		@GetMapping("/{id}")
		public MeuPet getPeloId(@PathVariable("id") String id) {
			return repo.findById(id).get();
		}

	
		@GetMapping
		public List<MeuPet> getMeuProduto(){
			return repo.findAll();
		}
		
		@PostMapping
		public String postProduto(@RequestBody MeuPet novo) {
			novo = repo.save(novo);
			return novo.getId();
		}

}
