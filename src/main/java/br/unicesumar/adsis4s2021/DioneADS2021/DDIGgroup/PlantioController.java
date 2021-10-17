package br.unicesumar.adsis4s2021.DioneADS2021.DDIGgroup;

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
@RequestMapping("/plantios")
public class PlantioController {
	
	@Autowired
	private PlantioRepository repo;
	

	@DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Plantio getPeloId(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}


	@GetMapping
	public List<Plantio> getPlantio(){
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody Plantio novo) {
		if (novo.getNome() != null && repo.findById(novo.getNome()).isPresent()) {
			throw new RuntimeException("Seu registro já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getNome();
	}

}
