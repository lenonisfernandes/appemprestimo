package br.edu.infnet.apicliente.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apicliente.model.domain.Cliente;
import br.edu.infnet.apicliente.model.domain.Usuario;
import br.edu.infnet.apicliente.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> obterLista() {
		return (List<Cliente>)clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public List<Cliente> obterLista(Integer userid) {
		return (List<Cliente>)clienteRepository.findAll(userid, Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

	public Long obterQnt() {
		return clienteRepository.count();
	}

	

}
