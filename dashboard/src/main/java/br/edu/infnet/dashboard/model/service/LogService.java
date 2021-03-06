package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.dashboard.clients.ILogClient;
import br.edu.infnet.dashboard.model.domain.Log;

@Service
public class LogService {
	
	@Autowired
	private ILogClient logClient;
	
	public List<Log> obterLista(){
		return logClient.obterLista();
	}
	
	public Long obterQuantidade() {
		return logClient.obterQuantidade();
	}
	
	public void incluir(Log log) {
		logClient.incluir(log);
	}
	
	public void excluir(Integer id) {
		logClient.excluir(id);
	}
	

}
