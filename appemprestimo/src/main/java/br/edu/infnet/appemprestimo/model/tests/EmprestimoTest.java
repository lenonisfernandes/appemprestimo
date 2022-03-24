package br.edu.infnet.appemprestimo.model.tests;

import br.edu.infnet.appemprestimo.model.domain.Cliente;
import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.*;

public class EmprestimoTest {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Carlos", "carlos@gmail.com", "12345678901");
		cliente.setId(2);
		Emprestimo emprestimo = new Emprestimo();
		
		Livro livro = new Livro();
		Academico academico = new Academico();
		Revista revista = new Revista();
		
		emprestimo.setId(1);
		emprestimo.setCliente(cliente);
		emprestimo.setDescricao("Livro para alugar");
		emprestimo.setWeb(true);
		emprestimo.addMateriais(livro);
		emprestimo.addMateriais(academico);
		emprestimo.addMateriais(revista);
		
		System.out.println(emprestimo.toString());
		

	}


}