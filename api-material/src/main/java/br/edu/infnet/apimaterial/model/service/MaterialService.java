package br.edu.infnet.apimaterial.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apimaterial.model.domain.Material;
import br.edu.infnet.apimaterial.model.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public void incluir(Material material) {
		materialRepository.save(material);
	}
	
	public List<Material> obterLista() {
		return (List<Material>)materialRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
	public Material obterPorId(Integer id) {
		return materialRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		materialRepository.deleteById(id);
	}

	public Long obterQnt() {
		return materialRepository.count();
	}
	
	public List<Material> obterLista(Integer userid) {
		return (List<Material>)materialRepository.obterLista(userid, Sort.by(Sort.Direction.ASC, "titulo"));
	}
	
}
