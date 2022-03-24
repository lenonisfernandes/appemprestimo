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

import br.edu.infnet.apimaterial.model.domain.Revista;
import br.edu.infnet.apimaterial.model.service.RevistaService;

@RestController
@RequestMapping("/api/material/revista")
public class RevistaController {
	
	@Autowired
	RevistaService revistaService;
	
	@GetMapping(value="/{userid}/listar")
	public List<Revista> obterLista(@PathVariable Integer userid) {
		return revistaService.obterLista(userid);
	}
	
	@GetMapping(value="/listar")
	public List<Revista> obterLista() {
		return revistaService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Revista revista) {
		revistaService.incluir(revista);
	}
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeRevista() {
		return revistaService.obterQnt();
	}
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		revistaService.excluir(id);
	}
	
	@GetMapping(value="/{id}")
	public Revista obterPorId(@PathVariable Integer id) {
		return revistaService.obterPorId(id);
	}
	
}
