package br.edu.infnet.appemprestimo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.appemprestimo.model.domain.Aluno;

@Controller
public class AlunoController {
	
	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		
		return "aluno/cadastro";
	}
	
	@GetMapping(value = "/alunos")
	public String telaLista(Model model) {
		
		List<Aluno> alunos = new ArrayList<Aluno>(
				Arrays.asList(
						new Aluno("Lenon Fernandes", "lenon@lenon.com"),
						new Aluno("Ignes", "ignes@ignes.com"),
						new Aluno("Bruna", "bruna@bruna.com")
						)
				);
		
		model.addAttribute("alunos", alunos);
		
		return "aluno/lista";
	}

	@PostMapping(value =  "/aluno/incluir")
	public String incluir(Model model, Aluno aluno) {
		
		model.addAttribute("mensagem", "O aluno"+aluno.getNome()+" foi cadastrado com sucesso.");
		
		return "aluno/lista";
	}
}
