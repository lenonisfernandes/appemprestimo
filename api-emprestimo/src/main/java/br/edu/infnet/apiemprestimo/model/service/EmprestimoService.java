 package br.edu.infnet.apiemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiemprestimo.model.domain.Emprestimo;
import br.edu.infnet.apiemprestimo.model.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public List<Emprestimo> obterLista() {
		return (List<Emprestimo>)emprestimoRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public List<Emprestimo> obterLista(Integer userid) {
		return (List<Emprestimo>)emprestimoRepository.findAll(userid, Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public Long obterQnt() {
		return emprestimoRepository.count();
	}
	
	public void incluir(Emprestimo emprestimo) {
		emprestimoRepository.save(emprestimo);
	}
	
	public void excluir(Integer id) {
		emprestimoRepository.deleteById(id);
	}
	
	public Emprestimo obterPorId(Integer id) {
		return emprestimoRepository.findById(id).orElse(null);
	}

	

}
