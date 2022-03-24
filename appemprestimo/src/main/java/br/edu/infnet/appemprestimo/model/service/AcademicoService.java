package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IAcademicoClient;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.appemprestimo.model.domain.Academico;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class AcademicoService {
	
	@Autowired
	private IAcademicoClient academicoClient;
	
	public List<Academico> obterLista() {
		
		return academicoClient.obterLista();
	}
	
	public List<Academico> obterLista(Usuario usuario) {
		
		return academicoClient.obterLista(usuario.getId());
	}
	
	public void incluir(Academico academico) throws QuantidadeAcademicoAlugadoException {
		academico.setAlugado(0);
		academicoClient.incluir(academico);
	}

	public Academico obterPorId(Integer id) {
		return academicoClient.obterPorId(id);
	}

	public void excluir(Integer id) {
		academicoClient.excluir(id);
	}

	public Long obterQnt() {
		return academicoClient.obterQuantidadeAcademico();
	}
}
