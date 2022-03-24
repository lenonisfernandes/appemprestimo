package br.edu.infnet.apimaterial.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apimaterial.model.domain.Academico;
import br.edu.infnet.apimaterial.model.repository.AcademicoRepository;

@Service
public class AcademicoService {
	
	@Autowired
	private AcademicoRepository academicoRepository;
	
	public Long obterQnt() {
		return academicoRepository.count();
	}
	
	public void incluir(Academico academico) {
		academicoRepository.save(academico);
	}
	
	public List<Academico> obterLista() {
		return (List<Academico>)academicoRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public Academico obterPorId(Integer id) {
		return academicoRepository.findById(id).orElse(null);
	}
	
	public List<Academico> obterLista(Integer userid) {
		return (List<Academico>)academicoRepository.obterLista(userid, Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public void excluir(Integer id) {
		academicoRepository.deleteById(id);
	}

}
