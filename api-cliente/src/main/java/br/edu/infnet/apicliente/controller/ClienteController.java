package br.edu.infnet.apicliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apicliente.model.domain.Cliente;
import br.edu.infnet.apicliente.model.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/listar")
	public List<Cliente> obterLista() {
		return clienteService.obterLista();
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Cliente cliente) {
		clienteService.incluir(cliente);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
	}
	
	//obter lista por usuario
	@GetMapping(value="/{userid}/listar")
	public List<Cliente> obterLista(@PathVariable Integer userid) {
		return clienteService.obterLista(userid);
	}
	
	//obter por id
	@GetMapping(value="/{id}")
	public Cliente obterPorId(@PathVariable Integer id) {
		return clienteService.obterPorId(id);
	}
	
	//quantidade
	@GetMapping(value="/quantidade")
	public long obterQuantidade() {
		return clienteService.obterQnt();
	}
	

}
