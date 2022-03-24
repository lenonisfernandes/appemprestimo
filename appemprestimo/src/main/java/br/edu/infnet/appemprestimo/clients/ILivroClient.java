package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Livro;

@FeignClient(url="localhost:8083/api/material/livro", name="livroClient")
public interface ILivroClient {
	
	@GetMapping(value="/{userid}/listar")
	public List<Livro> obterLista(@PathVariable Integer userid);
	
	@GetMapping(value="/listar")
	public List<Livro> obterLista();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Livro livro);
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value="/{id}")
	public Livro obterPorId(@PathVariable Integer id);
	
	@GetMapping(value="/quantidade")
	public long obterQuantidadeLivro();

	
}
