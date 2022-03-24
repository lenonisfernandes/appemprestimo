package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appemprestimo.model.domain.Endereco;
import br.edu.infnet.appemprestimo.model.service.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping(value="/cep")
	public String buscarCep(Model model, @RequestParam String cep) {
		
		
		model.addAttribute("endereco", enderecoService.obterPorCep(cep));
		
		
		return "usuario/cadastro";
	}

}
