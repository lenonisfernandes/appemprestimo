package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Material;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.MaterialService;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value="/materiais")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", materialService.obterLista(usuario));

		return "material/lista";
	}
	
	
	@GetMapping(value="/material/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Material material = materialService.obterPorId(id);
		try {
			materialService.excluir(id);
			model.addAttribute("mensagem", "O material "+material.getTitulo()+" foi removido "
					+ "com sucesso!");
	
		} catch (Exception e) {
			model.addAttribute("mensagem", "O material "+material.getTitulo()+" não pode ser removido."
					+ " Ele está associada a um empréstimo.");		}
		
		return telaLista(model, usuario);
	}

}
