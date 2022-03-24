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

import br.edu.infnet.apimaterial.model.domain.Academico;
import br.edu.infnet.apimaterial.model.service.AcademicoService;

@RestController
@RequestMapping("/api/material/academico")
public class AcademicoController {
	
	@Autowired
	AcademicoService academicoService;
	
	@GetMapping(value="/{userid}/listar")
	public List<Academico> obterLista(@PathVariable Integer userid) {
		return academicoService.obterLista(userid);
	}
	
	@GetMapping(value="/listar")
	public List<Academico> obterLista() {
		return academicoService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Academico academico) {
		academicoService.incluir(academico);
	}
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeAcademico() {
		return academicoService.obterQnt();
	}
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		academicoService.excluir(id);
	}
	
	@GetMapping(value="/{id}")
	public Academico obterPorId(@PathVariable Integer id) {
		return academicoService.obterPorId(id);
	}
	
}
