package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.LivroService;

@Controller
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value="/livros")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", livroService.obterLista(usuario));

		return "livro/lista";
	}
	
	@GetMapping(value="/livro")
	public String telaCadastro() {
		return "livro/cadastro";
	}
	
	@PostMapping(value="/livro/incluir")
	public String incluir(Model model, Livro livro, @SessionAttribute("user") Usuario usuario) throws QuantidadeAluguelNegativaException {
		
		model.addAttribute("mensagem", "O livro "+livro.getTitulo()+" foi cadastrado com sucesso.");
		
		livro.setUsuario(usuario);
		livroService.incluir(livro);
	
		return telaLista(model, usuario);
		
	}
	
	@GetMapping(value="/livro/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Livro livro = livroService.obterPorId(id);
		
		try {
			livroService.excluir(id);
			model.addAttribute("mensagem", "O livro "+livro.getTitulo()+" foi removido com sucesso!");
	
		} catch (Exception e) {
			model.addAttribute("mensagem", "O livro "+livro.getTitulo()+" não pode ser removido."
					+ " Ele está associada a um empréstimo.");
		}
		
		return telaLista(model, usuario);
	}

}
