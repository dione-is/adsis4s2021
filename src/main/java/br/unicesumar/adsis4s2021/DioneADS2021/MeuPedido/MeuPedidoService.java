package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuEstoque.MeuReservaDeEstoque;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuEstoque.MeuReservaDeEstoqueService;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuTotalVendidoDoProdutoDTO;

@Service
@Transactional
public class MeuPedidoService {
	
	@Autowired
	private MeuPedidoRepository repo;
	
	@Autowired
	private MeuReservaDeEstoqueService MeureservaDeEstoqueService;
	
	public List<MeuPedidoDTO> getAll() {
		List<MeuPedidoDTO> MeuspedidosDTO  = repo.encontrarTodosComoDTO();
		for (MeuPedidoDTO MeuspedidoDTO : MeuspedidosDTO) {
			MeuspedidoDTO.setItens(repo.encontrarItensPedidoDoPedidoDTO(MeuspedidoDTO.getId()));
		}
		return MeuspedidosDTO;
	}

	public String insert(MeuPedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		
		for (MeuItemPedido ip : novo.getItens()) {
			MeureservaDeEstoqueService.insert(new MeuReservaDeEstoque(novo.getCliente(), new Date(), ip.getProduto(), ip.getQuantidade()));
		
		}
		/*if ((10-10) == 0 ) {
			throw new RuntimeException("Opa, deu erro... deveria fazer um rollback!");
		}*/		
		novo = repo.save(novo);
		return novo.getId();
	}

	public List<Map<String, Object>> consultarTotalVendidoPorProduto() {
		return repo.consultarTotalVendidoPorProduto();	
	}

	public List<MeuTotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO() {
		return repo.consultarTotalVendidoPorProdutoDTO();
	}

	

}
