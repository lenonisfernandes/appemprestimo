package br.edu.infnet.apilog.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apilog.model.domain.Log;
import br.edu.infnet.apilog.model.repository.LogRepository;

@Service
public class LogService {
	
	@Autowired
	private LogRepository logRepository;
	
	public void incluir(Log log) {
		logRepository.save(log);
	}
	
	public List<Log> obterLista() {
		return (List<Log>)logRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public void excluir(Integer id) {
		logRepository.deleteById(id);
	}

	public Long obterQnt() {
		return logRepository.count();
	}
	

}
