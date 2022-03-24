package br.edu.infnet.appemprestimo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.Material;
import br.edu.infnet.appemprestimo.model.service.ClienteService;
import br.edu.infnet.appemprestimo.model.service.EmprestimoService;
import br.edu.infnet.appemprestimo.model.service.MaterialService;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;


@Component
@Order(4)
public class EmprestimoLoader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Material> materiais = new ArrayList<Material>();
		
		//materiais.add(materialService.obterPorId(2));
		//materiais.add(materialService.obterPorId(3));
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDescricao("Emprestimo para preprado de aulas");
		//emprestimo.setCliente(clienteService.obterPorId(1));
		emprestimo.setMateriais(materiais);
		//emprestimo.setUsuario(usuarioService.obterPorId(1));
		emprestimo.setWeb(false);
		
		//emprestimoService.incluir(emprestimo);
		
		
	}
	
}
