package br.unicesumar.adsis4s2021.DioneADS2021.MeuPessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.DioneADS2021.minhaBase.MinhaBaseController;

@RestController
@RequestMapping("/meuspessoas")
public class MeuPessoaController extends MinhaBaseController<MeuPessoa, MeuPessoaRepository>{

}
