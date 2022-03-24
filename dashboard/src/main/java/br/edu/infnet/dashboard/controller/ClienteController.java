package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	@GetMapping(value="/clientes")
	public String obterLista(Model model) {

		model.addAttribute("listagem", clienteService.obterLista());
		
		return "lista/clientes";
	}
//TODO @JsonIgnore (não aparece na listagem)  
//TODO tags para muitos para muitos 
//TODO @JsonManageReference classe que está listando
//TODO @JsonBackReference classe que não quer que repita
//TODO usar dashboard para acessar o api
//TODO colocar @JsonIgnore na api-pedido na classe Emprestimo atributo materiais
//TODO
}
