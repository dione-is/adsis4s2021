package br.unicesumar.adsis4s2021.DioneADS2021.MeuProduto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.unicesumar.adsis4s2021.DioneADS2021.MeuProduto.MeuProduto;

public interface MeuProdutoRepository extends JpaRepository<MeuProduto, String>{
	
	@Query("select p from MeuProduto p where p.preco >= :preco")
	List<MeuProduto> recuperarPrecoMaior(double preco);
	
	@Query(value = "select p.id, p.nome, p.preco from MeuProduto p where p.preco >= :preco ", nativeQuery = true)
	List<MeuProduto> recuperaPrecoMaior(double preco);

}
