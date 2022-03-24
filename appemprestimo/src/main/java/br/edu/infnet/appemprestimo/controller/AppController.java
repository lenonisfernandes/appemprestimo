package br.edu.infnet.appemprestimo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.AcademicoService;
import br.edu.infnet.appemprestimo.model.service.ClienteService;
import br.edu.infnet.appemprestimo.model.service.EmprestimoService;
import br.edu.infnet.appemprestimo.model.service.LivroService;
import br.edu.infnet.appemprestimo.model.service.MaterialService;
import br.edu.infnet.appemprestimo.model.service.RevistaService;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private LivroService livroService;
	@Autowired
	private AcademicoService academicoService;
	@Autowired
	private EmprestimoService emprestimoService;
	@Autowired
	private RevistaService revistaService;
	
	
	@GetMapping(value="/home")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value="/app")
	public String telaApp(Model model) {
		
		Map<String, Long> mapa = new HashMap<String, Long>();
		mapa.put("Usuários", usuarioService.obterQnt());
		mapa.put("Clientes", clienteService.obterQnt());
		mapa.put("Materiais", materialService.obterQnt());
		mapa.put("Acadêmicos", academicoService.obterQnt());
		mapa.put("Livros", livroService.obterQnt());
		mapa.put("Revistas", revistaService.obterQnt());
		mapa.put("Empréstimos", emprestimoService.obterQnt());
		
		model.addAttribute("myMap", mapa);
		return "app";
	}

}
