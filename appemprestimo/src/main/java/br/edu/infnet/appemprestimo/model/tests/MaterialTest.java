package br.edu.infnet.appemprestimo.model.tests;

import br.edu.infnet.appemprestimo.model.domain.*;

public class MaterialTest {
	
	public static void main(String[] args) {
		
		Academico academico = new Academico("Titulo", "autor", true);
		Livro livro = new Livro("Titulo", "autor", 10, 2, 2020);
		Revista revista = new Revista("Titulo", "autor");
		
		System.out.println(academico.toString()+"; "+academico.restante());
		System.out.println(livro.toString());
		System.out.println(revista.toString());
	}

}
