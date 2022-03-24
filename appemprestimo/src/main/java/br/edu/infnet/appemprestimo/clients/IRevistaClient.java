package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Revista;

@FeignClient(url="localhost:8083/api/material/revista", name="revistaClient")
public interface IRevistaClient {
	
	@GetMapping(value="/{userid}/listar")
	public List<Revista> obterLista(@PathVariable Integer userid);
	
	@GetMapping(value="/listar")
	public List<Revista> obterLista();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Revista revista);
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeRevista();
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value="/{id}")
	public Revista obterPorId(@PathVariable Integer id);
	
	
}
