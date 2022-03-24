package br.edu.infnet.apimaterial.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apimaterial.model.domain.Livro;
import br.edu.infnet.apimaterial.model.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Long obterQnt() {
		return livroRepository.count();
	}
	
	public void incluir(Livro livro) {
		System.out.println(livro.toString());
		livroRepository.save(livro);
	}
	
	public List<Livro> obterLista() {
		return (List<Livro>)livroRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public Livro obterPorId(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	public List<Livro> obterLista(Integer userid) {
		return (List<Livro>)livroRepository.obterLista(userid, Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public void excluir(Integer id) {
		livroRepository.deleteById(id);
	}
	

}
