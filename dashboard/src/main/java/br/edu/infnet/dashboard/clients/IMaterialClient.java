package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Material;

@FeignClient(url="localhost:8083/api/material", name="materialClient")
public interface IMaterialClient {
	
	@GetMapping(value="/listar")
	public List<Material> obterLista();
	
	@GetMapping(value="/livro/quantidade")
	public long quantidadeLivros();
	
	@GetMapping(value="/academico/quantidade")
	public long quantidadeAcademicos();
	
	@GetMapping(value="/revista/quantidade")
	public long quantidadeRevistas();

}
