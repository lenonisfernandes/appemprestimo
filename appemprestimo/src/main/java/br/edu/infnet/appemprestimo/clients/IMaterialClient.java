package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Material;

@FeignClient(url="localhost:8083/api/material", name="materialClient")
public interface IMaterialClient {
	
	@GetMapping(value = "/listar")
	public List<Material> obterLista();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Material material);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value="/{id}")
	public Material obterPorId(@PathVariable Integer id);
	
	@GetMapping(value = "/{userid}/listar")
	public List<Material> obterLista(@PathVariable Integer userid);

	@GetMapping(value = "/quantidade")
	public long obterQuantidade();
}
