package br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuItemPedidoDTO;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuTotalVendidoDoProdutoDTO;



public interface MeuPedidoRepository extends JpaRepository<MeuPedido, String> {

	
//	@Query(value = "select p.nome as produto, "
//			+ "sum(ip.quantidade * ip.preco_unitario) as \"totalVendido\" "
//			+ "from item_pedido ip "
//			+ "inner join produto p on p.id = ip.produto_id "
//			+ "group by p.nome", nativeQuery = true)
//	List<Map<String, Object>> consultarTotalVendidoPorProduto();


	@Query(value = "select p.nome as Meuproduto, "
			+ "sum(ip.quantidade * ip.precoUnitario) as totalVendido "
			+ "from MeuItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<Map<String, Object>> consultarTotalVendidoPorProduto();
	
	
	@Query(value = "select new br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuTotalVendidoDoProdutoDTO(p.nome, "
			+ "sum(ip.quantidade * ip.precoUnitario)) "
			+ "from MeuItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<MeuTotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO();


	@Query(value = "select new br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuPedidoDTO(p.id, p.numero, p.emitidoEm, c.id, c.nome) "
			+ "from MeuPedido p "
			+ "inner join p.cliente c")
	List<MeuPedidoDTO> encontrarTodosComoDTO(); 
	
	@Query(value = "select new br.unicesumar.adsis4s2021.DioneADS2021.MeuPedido.DTO.MeuItemPedidoDTO(ip.id, ip.quantidade, ip.percentualDeDesconto, ip.precoUnitario, prod.id, prod.nome) "
			+ "from Pedido p "
			+ "inner join p.itens ip "
			+ "inner join ip.produto prod "
			+ "where p.id = :pedidoId")
	List<MeuItemPedidoDTO> encontrarItensPedidoDoPedidoDTO(String pedidoId);
}
