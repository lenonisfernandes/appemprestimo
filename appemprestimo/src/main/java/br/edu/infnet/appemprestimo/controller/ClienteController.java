package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Cliente;
import br.edu.infnet.appemprestimo.model.domain.Endereco;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value="/clientes")
	private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", clienteService.obterLista(usuario));

		return "cliente/lista";
		
	}
	
	@GetMapping(value="/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
	
	@PostMapping(value="/cliente/incluir")
	public String incluir(Model model, Cliente cliente, @SessionAttribute("user") Usuario usuario, Endereco endereco) {
		
		model.addAttribute("mensagem", "O cliente "+cliente.getNome()+" foi cadastrado com sucesso.");
		
		cliente.setUsuario(usuario);
		cliente.setEndereco(endereco);
		clienteService.incluir(cliente);
	
		return telaLista(model, usuario);
		
	}
	
	@GetMapping(value="/cliente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Cliente cliente = clienteService.obterPorId(id);
		try {
			clienteService.excluir(id);
			model.addAttribute("mensagem", "O cliente "+cliente.getNome()+" foi removido com sucesso!");	
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o cliente "+cliente.getNome()+"!!! Ele está associado a um pedido");
		}
		
		return telaLista(model, usuario);
	}

}
