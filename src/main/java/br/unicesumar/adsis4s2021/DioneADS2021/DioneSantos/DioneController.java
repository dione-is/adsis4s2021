package br.unicesumar.adsis4s2021.DioneADS2021.DioneSantos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DioneSantos-controller")
public class DioneController {
		
		@GetMapping
		public String get() {
			return "olha, o DioneSantos controller esta funcionando";
		}
		
		@GetMapping("/teste")
		public String teste() {
			return "testando segundo getMapping";
		}
} //////////////////////////////////
