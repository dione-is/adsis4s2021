package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/meuspedidos")
public class MeuPedidoController {

		@Autowired
		private MeuPedidoRepository repo;
		
		@GetMapping
		public List<MeuPedido> getAll(){
			return repo.findAll();
		}
		
		@PostMapping
		public String post(@RequestBody MeuPedido novo) {
			if(repo.findById(novo.getId()).isPresent()){
				throw new RuntimeException("Seu pedido já existe");
			}
			novo = repo.save(novo);
			return novo.getId();
		}
		
		@DeleteMapping("/{id}")
		public void deletePeloId(@PathVariable("id") String id) {
			repo.deleteById(id);
		}
		
	
}
