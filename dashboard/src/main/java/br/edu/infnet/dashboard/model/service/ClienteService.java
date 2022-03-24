package br.edu.infnet.dashboard.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IClienteClient;
import br.edu.infnet.dashboard.model.domain.Cliente;
import br.edu.infnet.dashboard.model.domain.Endereco;

@Service
public class ClienteService {
	
	@Autowired
	private IClienteClient clienteClient;
	
	public List<Cliente> obterLista(){
		return clienteClient.obterLista();
	}

}
