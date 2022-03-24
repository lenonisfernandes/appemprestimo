package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Endereco;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;


@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Endereco endereco = new Endereco();
		endereco.setCep("26000000");
		endereco.setBairro("Centro");
		endereco.setComplemento("");
		endereco.setLocalidade("Nova Iguaçu");
		endereco.setLogradouro("Rua A");
		endereco.setUf("RJ");

		Usuario usuario = new Usuario();
		usuario.setEmail("lenon@lenon.com");
		usuario.setSenha("lenon@lenon.com");
		usuario.setNome("Lenon");
		usuario.setAdmin(true);
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
	}
	
}
