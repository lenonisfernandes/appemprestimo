package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.appemprestimo.model.domain.Academico;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.AcademicoService;

@Controller
public class AcademicoController {
	
	@Autowired
	private AcademicoService academicoService;
	
	@GetMapping(value="/academicos")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", academicoService.obterLista(usuario));

		return "academico/lista";
	}
	
	@GetMapping(value="/academico")
	public String telaCadastro() {
		return "academico/cadastro";
	}
	
	@PostMapping(value="/academico/incluir")
	public String incluir(Model model, Academico academico, @SessionAttribute("user") Usuario usuario) throws QuantidadeAcademicoAlugadoException {
		
		model.addAttribute("mensagem", "O material academico "+academico.getTitulo()+" foi "
				+ "cadastrado com sucesso.");
		
		academico.setUsuario(usuario);
		academicoService.incluir(academico);
	
		return telaLista(model, usuario);
		
	}
	
	
	@GetMapping(value="/academico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Academico academico = academicoService.obterPorId(id);
		
		try {
			academicoService.excluir(id);

			model.addAttribute("mensagem", "O material academico "+academico.getTitulo()+" foi removido "
					+ "com sucesso!");
		}catch (Exception e) {
			model.addAttribute("mensagem", "O material academico "+academico.getTitulo()+" não pode ser removido."
					+ " Ele está associada a um empréstimo.");
		}
		
		
		return telaLista(model, usuario);
	}

}
