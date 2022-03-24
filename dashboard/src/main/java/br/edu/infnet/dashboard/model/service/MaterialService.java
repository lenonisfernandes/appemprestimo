package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IMaterialClient;
import br.edu.infnet.dashboard.model.domain.Material;

@Service
public class MaterialService {
	
	@Autowired
	public IMaterialClient materialClient;
	
	public List<Material> obterLista(){
		return materialClient.obterLista();				
	}

	public long quantidadeLivros() {
		return materialClient.quantidadeLivros();
	}

	public long quantidadeAcademicos() {
		return materialClient.quantidadeAcademicos();

	}
	
	public long quantidadeRevistas() {
		return materialClient.quantidadeRevistas();

	}

}
