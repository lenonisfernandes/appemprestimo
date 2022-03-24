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

import br.edu.infnet.apimaterial.model.domain.Material;
import br.edu.infnet.apimaterial.model.service.MaterialService;

@RestController
@RequestMapping("/api/material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value = "/{userid}/listar")
	public List<Material> obterLista(@PathVariable Integer userid) {
		return materialService.obterLista(userid);
	}
	
	@GetMapping(value = "/listar")
	public List<Material> obterLista() {
		return materialService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Material material) {
		materialService.incluir(material);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		materialService.excluir(id);
	}
	
	@GetMapping(value="/{id}")
	public Material obterPorId(@PathVariable Integer id) {
		return materialService.obterPorId(id);
	}
	
	@GetMapping(value = "/quantidade")
	public long obterQuantidade() {
		return materialService.obterQnt();
	}
	
}
