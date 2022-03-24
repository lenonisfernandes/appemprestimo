package br.edu.infnet.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.EmprestimoService;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.MaterialService;
import br.edu.infnet.dashboard.model.service.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private LogService logService;
	
	@GetMapping(value="/")
	public String index(Model model) {
		
		//Materiais e emprestimo por usuário
		List<Usuario> usuarios = usuarioService.obterLista();
		model.addAttribute("emprestimoPorUsuario", usuarios);
		model.addAttribute("materiaisPorUsuario", usuarios);
		
		//Quantidade de emprestimos
		model.addAttribute("quantidadeEmprestimos", emprestimoService.obterQuantidade());
		
		//Quantidade de Academicos
		model.addAttribute("quantidadeAcademicos", materialService.quantidadeAcademicos());
		
		//Quantidade de Livros
		model.addAttribute("quantidadeLivros", materialService.quantidadeLivros());
		
		//Quantidade de Revistas
		model.addAttribute("quantidadeRevistas", materialService.quantidadeRevistas());
		
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qntdeLog", logService.obterQuantidade());
		
		return "index";
	}

}
