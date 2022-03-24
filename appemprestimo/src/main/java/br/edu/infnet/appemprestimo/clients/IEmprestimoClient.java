package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Emprestimo;

@FeignClient(url="localhost:8084/api/emprestimo", name="emprestimoClient")
public interface IEmprestimoClient {
	
	@GetMapping(value = "/listar")
	public List<Emprestimo> obterLista();

	@GetMapping(value = "/{userid}/listar")
	public List<Emprestimo> obterLista(@PathVariable Integer userid);
	
	@GetMapping(value="/quantidade")
	public long obterQuantidade();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Emprestimo emprestimo);
	
	@DeleteMapping(value="/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value="/{id}")
	public Emprestimo obterPorId(@PathVariable Integer id);
	
	
}
