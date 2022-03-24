package br.edu.infnet.appemprestimo.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController extends HttpServlet{
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String telaLogout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}
	
	
	@PostMapping(value="/login")
	public String acessar(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario usuario = usuarioService.validar(email, senha);
		model.addAttribute("user", usuario);
		if(usuario!=null) {
			return "index";
		} else {
			model.addAttribute("mensagem", "Impossível realizar a autenticação: "+email+"!");
			
			return "login";
		}
		
	}

}
