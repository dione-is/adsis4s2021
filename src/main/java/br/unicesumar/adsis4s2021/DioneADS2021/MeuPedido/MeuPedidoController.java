package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuTotalVendidoDoProdutoDTO;


@RestController
@RequestMapping("/meuspedidos")
public class MeuPedidoController {

		@Autowired
		private MeuPedidoService service;
		
		@GetMapping
		public List<MeuPedidoDTO> getAll(){
			return service.getAll();
		}
		
		@PostMapping
		public String post(@RequestBody MeuPedido novo) {
			return service.insert(novo);
		}
		
		@GetMapping("/totalVendidoPorProduto")
		public List<Map<String, Object>> getTotalVendidoPorProduto() {
			return service.consultarTotalVendidoPorProduto();
		}

		@GetMapping("/totalVendidoPorProdutoDTO")
		public List<MeuTotalVendidoDoProdutoDTO> getTotalVendidoPorProdutoDTO() {
			return service.consultarTotalVendidoPorProdutoDTO();
		}
		
	
}
