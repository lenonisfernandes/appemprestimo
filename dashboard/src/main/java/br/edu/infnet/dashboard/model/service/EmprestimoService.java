package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IEmprestimoClient;
import br.edu.infnet.dashboard.model.domain.Emprestimo;

@Service
public class EmprestimoService {
	
	@Autowired
	private IEmprestimoClient emprestimoClient;
	
	public List<Emprestimo> obterLista() {
		return emprestimoClient.obterLista();
	}
	
	public long obterQuantidade() {
		return emprestimoClient.obterQuantidade();
	}

}
