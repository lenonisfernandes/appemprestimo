package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Emprestimo;

@FeignClient(url="localhost:8084/api/emprestimo", name="emprestimoClient")
public interface IEmprestimoClient {
	
	@GetMapping(value="/listar")
	public List<Emprestimo> obterLista();
	
	@GetMapping(value="/quantidade")
	public long obterQuantidade();
}
