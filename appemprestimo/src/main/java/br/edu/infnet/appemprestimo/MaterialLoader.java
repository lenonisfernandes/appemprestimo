package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Academico;
import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.AcademicoService;
import br.edu.infnet.appemprestimo.model.service.LivroService;
import br.edu.infnet.appemprestimo.model.service.RevistaService;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;


@Component
@Order(3)
public class MaterialLoader implements ApplicationRunner {

	@Autowired
	private AcademicoService academicoService;
	@Autowired
	private LivroService livroService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RevistaService revistaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Usuario usuario = usuarioService.obterPorId(1);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Academico academico = new Academico("The Laws of Engagement", "Hamilton, A.L.", false);
		academico.setIdioma("en");
		academico.setTipo("artigo");
		academico.setUsuario(usuario);
		
		
		//academicoService.incluir(academico);
		
		Academico a2 = new Academico("Ensino de Matemática usando Redes Sociais", "Fernandes, L. I. dos S.",
				true);
		a2.setIdioma("pt");
		a2.setTipo("artigo");
		a2.setUsuario(usuario);
		
		//academicoService.incluir(a2);
		
		Livro livro = new Livro();
		livro.setAno(2020);
		livro.setAutor("Autor1");
		livro.setEdicao(5);
		livro.setQnt(25);
		livro.setTitulo("Livro2");
		livro.setUsuario(usuario);
		
		//livroService.incluir(livro);
		
		Revista revista = new Revista();
		revista.setAno(2021);
		revista.setEdicao(34);
		revista.setMes(4);
		revista.setTitulo("JAVA for kids");
		revista.setUsuario(usuario);
		
		//revistaService.incluir(revista);
		
	}
	
}
