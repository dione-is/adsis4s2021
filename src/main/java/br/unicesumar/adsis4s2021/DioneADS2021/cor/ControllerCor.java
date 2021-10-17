package br.unicesumar.adsis4s2021.DioneADS2021.cor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cores")
public class ControllerCor {
	
	private List<Cor> cores = new ArrayList<Cor>();
	
	public ControllerCor() {
		this.cores.add(new Cor("Preto","BLK"));
		this.cores.add(new Cor("Azul","BLE"));
		this.cores.add(new Cor("Branco","WHL"));
	}
	
	@GetMapping
	public List<Cor> getCores(){
		return this.cores;
	}
	
	@PostMapping
	public void postCor(@RequestBody Cor nova) {
		this.cores.add(nova);
	}

}
