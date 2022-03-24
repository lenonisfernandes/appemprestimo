package br.edu.infnet.appemprestimo.model.tests;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;
import br.edu.infnet.appemprestimo.model.domain.Livro;

public class LivroTest {

	public static void main(String[] args) {
		
		try {
			Livro livro = new Livro("Titulo", "Autor", 3, 2, 2020);
			livro.setAlugado(-4);
			System.out.println(livro.toString()+"; "+livro.restante());

		} catch (QuantidadeAluguelNegativaException e) {
			e.printStackTrace();
		}
		

	}

}
