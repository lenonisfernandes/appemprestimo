package br.edu.infnet.appemprestimo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.Material;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.ClienteService;
import br.edu.infnet.appemprestimo.model.service.EmprestimoService;
import br.edu.infnet.appemprestimo.model.service.MaterialService;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value="/emprestimos")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", emprestimoService.obterLista(usuario));

		return "emprestimo/lista";
	}
	
	@GetMapping(value="/emprestimo")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("clientes", clienteService.obterLista(usuario));
		model.addAttribute("materiais", materialService.obterLista(usuario));
		
		return "emprestimo/cadastro";
	}
	
	@PostMapping(value="/emprestimo/incluir")
	public String incluir(Model model, @RequestParam String[] materiaisId, Emprestimo emprestimo, @SessionAttribute("user") Usuario usuario) {
		
		System.out.println(Arrays.toString(materiaisId));
		
		model.addAttribute("mensagem", "O emprestimo "+emprestimo.getDescricao()+" foi "
				+ "cadastrado com sucesso.");
		
		List<Material> materiais = new ArrayList<Material>();
		
		for(String id : materiaisId) {
			
			materiais.add(materialService.obterPorId(Integer.valueOf(id)));
		}
		
		emprestimo.setMateriais(materiais);
		emprestimo.setUsuario(usuario);
		emprestimoService.incluir(emprestimo);
	
		return telaLista(model, usuario);
		
	}
	
	
	@GetMapping(value="/emprestimo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Emprestimo emprestimo = emprestimoService.obterPorId(id);
		
		emprestimoService.excluir(id);

		model.addAttribute("mensagem", "O emprestimo "+emprestimo.getDescricao()+" foi removido "
				+ "com sucesso!");

		return telaLista(model, usuario);
	}

}
