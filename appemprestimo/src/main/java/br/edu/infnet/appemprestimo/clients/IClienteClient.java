package br.edu.infnet.appemprestimo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appemprestimo.model.domain.Cliente;

@FeignClient(url="localhost:8082/api/cliente", name="clienteClient")
public interface IClienteClient {
	
	@GetMapping(value = "/listar")
	public List<Cliente> obterLista();
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Cliente cliente);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	//obter lista por usuario
	@GetMapping(value="/{userid}/listar")
	public List<Cliente> obterLista(@PathVariable Integer userid);
	
	//obter por id
	@GetMapping(value="/{id}")
	public Cliente obterPorId(@PathVariable Integer id);
	
	//quantidade
	@GetMapping(value="/quantidade")
	public long obterQuantidade();
	
	
}
