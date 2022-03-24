package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.RevistaService;

@Controller
public class RevistaController {
	
	@Autowired
	private RevistaService revistaService;
	
	@GetMapping(value="/revistas")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", revistaService.obterLista(usuario));

		return "revista/lista";
	}
	
	@GetMapping(value="/revista")
	public String telaCadastro() {
		return "revista/cadastro";
	}
	
	@PostMapping(value="/revista/incluir")
	public String incluir(Model model, Revista revista, @SessionAttribute("user") Usuario usuario) throws QuantidadeAluguelNegativaException {
		
		model.addAttribute("mensagem", "A revista "+revista.getTitulo()+" foi "
				+ "cadastrada com sucesso.");
		
		revista.setUsuario(usuario);
		revistaService.incluir(revista);
	
		return telaLista(model, usuario);
		
	}
	
	
	@GetMapping(value="/revista/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Revista revista = revistaService.obterPorId(id);
		
		try {
			revistaService.excluir(id);

			model.addAttribute("mensagem", "A revista "+revista.getTitulo()+" foi removida "
					+ "com sucesso!");
		}catch (Exception e) {
			model.addAttribute("mensagem", "O revista "+revista.getTitulo()+" não pode ser removida."
					+ " Ela está associada a um empréstimo.");
		}
		
		
		return telaLista(model, usuario);
	}

}
