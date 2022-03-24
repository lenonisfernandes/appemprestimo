package br.edu.infnet.apiemprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiemprestimo.model.domain.Emprestimo;
import br.edu.infnet.apiemprestimo.model.service.EmprestimoService;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping(value = "/listar")
	public List<Emprestimo> obterLista() {
		return emprestimoService.obterLista();
	}
	
	@GetMapping(value="/quantidade")
	public long obterQuantidade() {
		return emprestimoService.obterQnt();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Emprestimo emprestimo) {
		emprestimoService.incluir(emprestimo);
	}
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		emprestimoService.excluir(id);
	}
	
	@GetMapping(value = "/{userid}/listar")
	public List<Emprestimo> obterLista(@PathVariable Integer userid) {
		return emprestimoService.obterLista(userid);
	}
	
	@GetMapping(value="/{id}")
	public Emprestimo obterPorId(@PathVariable Integer id) {
		return emprestimoService.obterPorId(id);
	}
	
	

}
