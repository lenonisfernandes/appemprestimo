package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IMaterialClient;
import br.edu.infnet.appemprestimo.model.domain.Material;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class MaterialService {
	
	@Autowired
	private IMaterialClient materialClient;
	
	public List<Material> obterLista(Usuario usuario) {
		return materialClient.obterLista(usuario.getId());
	}
	
	public Material obterPorId(Integer id) {
		return materialClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		materialClient.excluir(id);
	}

	public Long obterQnt() {
		return materialClient.obterQuantidade();
	}
}
