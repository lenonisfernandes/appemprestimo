package br.edu.infnet.apimaterial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apimaterial.model.domain.Livro;
import br.edu.infnet.apimaterial.model.service.LivroService;

@RestController
@RequestMapping("/api/material/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping(value="/{userid}/listar")
	public List<Livro> obterLista(@PathVariable Integer userid) {
		return livroService.obterLista(userid);
	}
	
	@GetMapping(value="/listar")
	public List<Livro> obterLista() {
		return livroService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Livro livro) {
		livroService.incluir(livro);
	}
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		livroService.excluir(id);
	}
	
	@GetMapping(value="/{id}")
	public Livro obterPorId(@PathVariable Integer id) {
		return livroService.obterPorId(id);
	}
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeLivro() {
		return livroService.obterQnt();
	}
	
}
