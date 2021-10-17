package br.unicesumar.adsis4s2021.DioneADS2021.MInhacidade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseController;

@RestController
@RequestMapping("/minhacidade")
public class MinhaCidadeController extends MinhaBaseController< MinhaCidade, MinhaCidadeRepository> {

}
