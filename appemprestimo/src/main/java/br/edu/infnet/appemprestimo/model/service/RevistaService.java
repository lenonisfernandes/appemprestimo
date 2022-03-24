package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IRevistaClient;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class RevistaService {
	
	@Autowired
	private IRevistaClient revistaClient;
	
	public List<Revista> obterLista() {
		return revistaClient.obterLista();
	}
	
	public List<Revista> obterLista(Usuario usuario) {
		return revistaClient.obterLista(usuario.getId());
	}
	
	public void incluir(Revista revista) throws QuantidadeAluguelNegativaException {
		revista.setAlugado(0);
		revistaClient.incluir(revista);
	}

	public Revista obterPorId(Integer id) {
		return revistaClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		revistaClient.excluir(id);
	}

	public Long obterQnt() {
		return revistaClient.obterQuantidadeRevista();
	}


}
