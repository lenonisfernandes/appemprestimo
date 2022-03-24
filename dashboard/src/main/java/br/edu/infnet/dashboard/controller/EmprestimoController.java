package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.EmprestimoService;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping(value="/emprestimos")
	private String obterLista(Model model) {
		model.addAttribute("listagem", emprestimoService.obterLista());
		return "lista/emprestimos";
	}

}
