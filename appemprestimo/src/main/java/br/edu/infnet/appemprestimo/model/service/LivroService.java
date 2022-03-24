package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.ILivroClient;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class LivroService {
	
	@Autowired
	private ILivroClient livroClient;
	
	public List<Livro> obterLista() {
		return livroClient.obterLista();
	}
	
	public List<Livro> obterLista(Usuario usuario) {
		return livroClient.obterLista(usuario.getId());
	}
	
	public void incluir(Livro livro) throws QuantidadeAluguelNegativaException {
		livro.setAlugado(0);
		livroClient.incluir(livro);
	}

	public Livro obterPorId(Integer id) {
		return livroClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		livroClient.excluir(id);
	}

	public Long obterQnt() {
		return livroClient.obterQuantidadeLivro();
	}


}
