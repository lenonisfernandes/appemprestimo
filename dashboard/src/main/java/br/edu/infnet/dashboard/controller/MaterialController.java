package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.MaterialService;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value="/materiais")
	public String obterLista(Model model) {
		model.addAttribute("listagem", materialService.obterLista());
		return "lista/materiais";
	}
}
