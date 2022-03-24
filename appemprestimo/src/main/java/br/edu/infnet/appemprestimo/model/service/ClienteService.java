package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IClienteClient;
import br.edu.infnet.appemprestimo.model.domain.Cliente;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class ClienteService {
	
	@Autowired
	private IClienteClient clienteClient;
	
	public List<Cliente> obterLista(Usuario usuario) {
		return clienteClient.obterLista(usuario.getId());
	}
	
	public List<Cliente> obterLista() {
		return (List<Cliente>)clienteClient.obterLista();
	}
	
	public void incluir(Cliente cliente) {
		
		clienteClient.incluir(cliente);
	}

	public Cliente obterPorId(Integer id) {
		return clienteClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		clienteClient.excluir(id);
		
	}

	public Long obterQnt() {
		// TODO Auto-generated method stub
		return clienteClient.obterQuantidade();
	}


}
