package br.edu.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.clients.IUsuarioClient;
import br.edu.infnet.appemprestimo.model.domain.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioClient usuarioClient;
	
	public Usuario validar(String email, String senha) {
		return usuarioClient.validar(email, senha);
	}
	
	public void incluir(Usuario usuario) {
		usuarioClient.incluir(usuario);
	}
	
	public List<Usuario> obterLista() {
		return (List<Usuario>)usuarioClient.obterLista();
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioClient.obterPorId(id);
	}
	
	public void excluir(Integer id) {
		usuarioClient.excluir(id);
	}

	public Long obterQnt() {
		return usuarioClient.obterQnt();
	}

	

}
