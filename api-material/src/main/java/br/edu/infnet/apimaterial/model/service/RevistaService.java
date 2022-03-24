package br.edu.infnet.apimaterial.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apimaterial.model.domain.Revista;
import br.edu.infnet.apimaterial.model.repository.RevistaRepository;

@Service
public class RevistaService {
	
	@Autowired
	private RevistaRepository revistaRepository;
	
	public Long obterQnt() {
		return revistaRepository.count();
	}
	
	public void incluir(Revista revista) {
		revistaRepository.save(revista);
	}
	
	public List<Revista> obterLista() {
		return (List<Revista>)revistaRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public Revista obterPorId(Integer id) {
		return revistaRepository.findById(id).orElse(null);
	}
	
	public List<Revista> obterLista(Integer userid) {
		return (List<Revista>)revistaRepository.obterLista(userid, Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public void excluir(Integer id) {
		revistaRepository.deleteById(id);
	}
}
