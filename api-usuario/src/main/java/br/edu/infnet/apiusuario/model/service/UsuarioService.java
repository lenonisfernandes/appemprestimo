package br.edu.infnet.apiusuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiusuario.model.domain.Usuario;
import br.edu.infnet.apiusuario.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario validar(String email, String senha) {
		return usuarioRepository.autenticacao(email, senha);
	}
	
	public String incluir(Usuario usuario) {
		
		List<Usuario> usuarios = obterLista();
		
		for(Usuario u : usuarios) {
			if (u.getEmail().equals(usuario.getEmail())) {
				return "Email já cadastrado.";
			}
		}
		
		usuarioRepository.save(usuario);
		return "Usuário cadastrado.";
		
	}
	
	public void incluirTeste(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obterLista() {
		
		return (List<Usuario>)usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Long obterQnt() {
		return usuarioRepository.count();
	}

	

}
