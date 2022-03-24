package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IEmprestimoClient;
import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class EmprestimoService {
	
	@Autowired
	private IEmprestimoClient emprestimoClient;
	
	public List<Emprestimo>obterLista() {
		return emprestimoClient.obterLista();
	}
	
	public List<Emprestimo>obterLista(Usuario usuario) {
		return emprestimoClient.obterLista(usuario.getId());
	}
	
	public void incluir (Emprestimo emprestimo) {
		emprestimoClient.incluir(emprestimo);
	}
	
	public void excluir(Integer id) {
		emprestimoClient.excluir(id);
	}
	
	public Emprestimo obterPorId(Integer id) {
		return emprestimoClient.obterPorId(id);
	}

	public Long obterQnt() {
		return emprestimoClient.obterQuantidade();
	}
	
}
