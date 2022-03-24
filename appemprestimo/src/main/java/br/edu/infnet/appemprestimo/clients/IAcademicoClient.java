package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Academico;

@FeignClient(url="localhost:8083/api/material/academico", name="academicoClient")
public interface IAcademicoClient {
	
	@GetMapping(value="/{userid}/listar")
	public List<Academico> obterLista(@PathVariable Integer userid);
	
	@GetMapping(value="/listar")
	public List<Academico> obterLista();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Academico academico);
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeAcademico();
	
	@GetMapping(value="/{id}")
	public Academico obterPorId(@PathVariable Integer id);
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	
}
